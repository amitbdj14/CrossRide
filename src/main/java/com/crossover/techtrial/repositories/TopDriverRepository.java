package com.crossover.techtrial.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RestResource;

import com.crossover.techtrial.dto.TopDriverDTO;
import com.crossover.techtrial.model.Ride;

@RestResource(exported = false)
public interface TopDriverRepository extends CrudRepository<Ride, Long> {
	@Query(value = "SELECT * FROM RIDE AS r, PERSON AS p WHERE r.start_time = ?1 and r.end_time = ?2 LIMIT count=?3", nativeQuery = true)
	public List<TopDriverDTO> getTopDriverBetweenStartDateandEndDate(Long count, LocalDateTime startTime, LocalDateTime endTime);
	
}
