package tn.association.management.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import tn.association.management.persistence.dao.AvailabilityRepository;
import tn.association.management.persistence.model.Availability;
import tn.association.management.persistence.model.Teacher;
import tn.association.management.service.AvailabilityService;
import tn.association.management.web.dto.AvailabilityDTO;
import tn.association.management.web.dto.mapper.AvailabilityMapper;
import tn.association.management.web.exception.EntityNotFoundException;
import tn.association.management.web.exception.NullAttributeException;
import tn.association.management.web.exception.WrongAvailabilityException;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

public class AvailabilityServiceImpl implements AvailabilityService {

    @Autowired
    private AvailabilityMapper availabilityMapper;

    @Autowired
    private AvailabilityRepository availabilityRepository;

    @Override
    public AvailabilityDTO getAvailabilityById(Long id) {
        Availability foundAvailability = getAvailabilitybyIdOrThrowException(id);
        return availabilityMapper.convertToDTO(foundAvailability);
    }

    @Override
    public AvailabilityDTO addAvailability(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        if (day == null || startTime == null || endTime == null) {
            throw new NullAttributeException("One of the given parameter is null");
        }
        Availability availability = availabilityRepository.save(new Availability(day, startTime, endTime));
        return availabilityMapper.convertToDTO(availability);
    }

    @Override
    public AvailabilityDTO linkAvailabilityToTeacher(Long availabilityId, Teacher teacher) {
        if (teacher == null) {
            throw new NullAttributeException("The teacher must be not null");
        }
        Availability availability = getAvailabilitybyIdOrThrowException(availabilityId);
        availability.setTeacher(teacher);
        availability = availabilityRepository.save(availability);
        return availabilityMapper.convertToDTO(availability);
    }

    @Override
    public AvailabilityDTO reserveAvailability(Long availabilityId) {
        Availability availability = getAvailabilitybyIdOrThrowException(availabilityId);
        if(availability.getInUse()){
            throw new WrongAvailabilityException("the teacher's availability is already reserved.");
        }
        availability.setInUse(true);
        availability = availabilityRepository.save(availability);
        return availabilityMapper.convertToDTO(availability);
    }

    @Override
    public AvailabilityDTO reservePartOfAvailability(Long availabilityId, LocalTime startTime, LocalTime endTime) {
        Availability availability = getAvailabilitybyIdOrThrowException(availabilityId);

        if(availability.getInUse()){
            throw new WrongAvailabilityException("the teacher's availability is already reserved.");
        }

        if(availability.getStartTime().equals(startTime) && availability.getEndTime().equals(endTime)){
            availability.setInUse(true);
            availability = availabilityRepository.save(availability);
            return availabilityMapper.convertToDTO(availability);
        } else if(availability.getStartTime().isAfter(startTime) || availability.getEndTime().isBefore(endTime)) {
            throw new WrongAvailabilityException("the teacher isn't available on the wanted time slot.");
        } else if(availability.getStartTime().isBefore(startTime) && availability.getEndTime().isAfter(endTime)){
            LocalTime finalAvailabilityEndTime = availability.getEndTime();
            Availability reservedAvailability = createUnreservedBeforeReservation(availability, startTime, endTime);
            availabilityRepository.save(new Availability(availability.getDay(), endTime, finalAvailabilityEndTime));
            return availabilityMapper.convertToDTO(reservedAvailability);
        } else if(availability.getStartTime().isBefore(startTime)){
            Availability reservedAvailability = createUnreservedBeforeReservation(availability, startTime, endTime);
            return availabilityMapper.convertToDTO(reservedAvailability);
        } else {
            LocalTime finalAvailabilityEndTime = availability.getEndTime();
            availability.setEndTime(endTime);
            availability.setInUse(true);
            availability = availabilityRepository.save(availability);

            availabilityRepository.save(new Availability(availability.getDay(), endTime, finalAvailabilityEndTime));
            return availabilityMapper.convertToDTO(availability);
        }
    }

    private Availability createUnreservedBeforeReservation(Availability availability, LocalTime startTime, LocalTime endTime){
        availability.setEndTime(startTime);
        availabilityRepository.save(availability);
        Availability reservedAvailability = new Availability(availability.getDay(), startTime, endTime);
        reservedAvailability.setInUse(true);
        return availabilityRepository.save(reservedAvailability);
    }

    @Override
    public AvailabilityDTO editAvailability(Long availabilityId, DayOfWeek day, LocalTime startTime, LocalTime endTime, Teacher teacher) {
        return null;
    }

    @Override
    public void deleteAvailability(Long availabilityId) {

    }

    @Override
    public List<AvailabilityDTO> getAllAvailabilities() {
        return List.of();
    }

    @Override
    public List<AvailabilityDTO> getAvailabilitiesByDay(DayOfWeek day) {
        return List.of();
    }

    @Override
    public List<AvailabilityDTO> getAvailabilitiesByDayAndStartTimeAndEndTime(DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        return List.of();
    }

    @Override
    public AvailabilityDTO getTeacherAvailability(Long teacherId, DayOfWeek day, LocalTime startTime, LocalTime endTime) {
        return null;
    }

    @Override
    public List<AvailabilityDTO> getTeacherAvailabilitiesByDay(DayOfWeek day) {
        return List.of();
    }


    private Availability getAvailabilitybyIdOrThrowException(Long id){
        if (id == null) {
            throw new NullAttributeException("The id must be not null");
        }
        return availabilityRepository.
                findById(id).orElseThrow(() -> new EntityNotFoundException(" there is no Availability with the given id" + id));

    }
}
