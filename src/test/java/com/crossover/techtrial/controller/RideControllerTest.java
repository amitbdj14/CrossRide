package com.crossover.techtrial.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.crossover.techtrial.CrossRideApplicationTest;
import com.crossover.techtrial.model.Person;
import com.crossover.techtrial.model.Ride;
import com.crossover.techtrial.repositories.RideRepository;
import com.crossover.techtrial.repositories.TopDriverRepository;

public class RideControllerTest extends CrossRideApplicationTest {

	  
	  MockMvc mockMvc;
	  
	  @Mock
	  private RideController rideController;
	  
	  @Autowired
	  private TestRestTemplate template;
	  
	  @Autowired
	  RideRepository rideRepository;
	  
	  @Autowired
	  TopDriverRepository topDriverRepo;
	  
	  @Before
	  public void setup() throws Exception {
	    mockMvc = MockMvcBuilders.standaloneSetup(rideController).build();
	  }
	  
	  @Test
	  public void testPanelShouldBeRegistered() throws Exception {
	    HttpEntity<Object> ride = getHttpEntity(
	        "{\"startTime\": \"2018-08-24T09:00:00\", \"endTime\": \"2018-08-25T10:00:00\"," 
	            + " \"distance\": \"4000\"}");
	    ResponseEntity<Ride> response = template.postForEntity(
	        "/api/ride", ride, Ride.class);
	    rideRepository.delete(response.getBody().getId());
	    Assert.assertEquals("test 1", response.getBody().getDistance());
	    Assert.assertEquals(200,response.getStatusCode().value());
	  }
	  
	  @Test
	  public void testPanelShouldGetAll() throws Exception {
	    ResponseEntity<Ride> response = template.getForEntity("/api/ride", Ride.class);
	    rideRepository.findAll();
	    Assert.assertEquals("test 1", response.getBody().getDistance());
	    Assert.assertEquals(200,response.getStatusCode().value());
	  }
	  
	  @Test
	  public void testPanelShouldGetByID() throws Exception {
	    ResponseEntity<Ride> response = template.getForEntity("/api/ride/{ride-id}", Ride.class);
	    rideRepository.findById(response.getBody().getId());
	    Assert.assertEquals(200,response.getStatusCode().value());
	  }
	  
	  @Test
	  public void testPanelShouldBeUpdated() throws Exception {
		Person p=new Person();
		p.setId(101L);
		p.setEmail("aa@gmail.com");
		p.setName("test7");
		p.setRegistrationNumber("testDL7");
		Ride r=new Ride();
		r.setDriver(p);
		ResponseEntity<Ride> response = template.postForEntity(
			        "/api/ride/{ride-id}", p, Ride.class);
	    rideRepository.save(r);
	    Assert.assertEquals(200,response.getStatusCode().value());
	  }
	  
	  @Test
	  public void testPanelShouldgetTop5Drivers() throws Exception {
		Ride r=getRide();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/mm/dd'T'hh:mm:ss");
		LocalDateTime ldtStartTime=LocalDateTime.parse(r.getStartTime(), formatter);
		LocalDateTime ldtEndTime=LocalDateTime.parse(r.getEndTime(), formatter);
		ResponseEntity<Ride> response = template.getForEntity("/api/top-rides", Ride.class);
	    topDriverRepo.getTopDriverBetweenStartDateandEndDate(5L, ldtStartTime, ldtEndTime);
	    Assert.assertEquals(200,response.getStatusCode().value());
	  }


	  private HttpEntity<Object> getHttpEntity(Object body) {
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    return new HttpEntity<Object>(body, headers);
	  }



}
