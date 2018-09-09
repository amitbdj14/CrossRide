package com.crossover.techtrial.service;

import java.time.LocalDateTime;
import java.util.List;

import com.crossover.techtrial.dto.TopDriverDTO;

public interface TopDriverService {
	
	public List<TopDriverDTO> getTopDriverBetweenStartDateandEndDate(Long count, LocalDateTime startTime, LocalDateTime endTime);

}
