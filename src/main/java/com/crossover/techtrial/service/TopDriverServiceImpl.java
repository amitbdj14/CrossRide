package com.crossover.techtrial.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crossover.techtrial.dto.TopDriverDTO;
import com.crossover.techtrial.repositories.TopDriverRepository;

@Service
public class TopDriverServiceImpl implements TopDriverService{

	@Autowired
	TopDriverRepository topDriverRepo;
	

	@Override
	public List<TopDriverDTO> getTopDriverBetweenStartDateandEndDate(Long count, LocalDateTime startTime,
			LocalDateTime endTime) {
		return (List<TopDriverDTO>) topDriverRepo.getTopDriverBetweenStartDateandEndDate(count,startTime,endTime);
	}
	
	

}
