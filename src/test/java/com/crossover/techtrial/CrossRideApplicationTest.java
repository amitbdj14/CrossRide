/**
 * 
 */
package com.crossover.techtrial;

import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import com.crossover.techtrial.model.Person;
import com.crossover.techtrial.model.Ride;

/**
 * @author crossover
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class CrossRideApplicationTest {
	
	public Person getPerson(){
		Person p=new Person();
		p.setEmail("aa@gmail.com");
		p.setName("test7");
		p.setRegistrationNumber("testDL7");
		return p;
	}
	
	public Ride getRide(){
		Ride r=new Ride();
		//DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/mm/dd'T'hh:mm:ss");
		r.setStartTime("2018-08-24T09:00:00");
		r.setEndTime("2018-08-25T10:00:00");
		
		r.setDriver(getPerson());
		r.setRider(getPerson());
		/*LocalDateTime ldtStartTime=LocalDateTime.parse(r.getStartTime(), formatter);
		LocalDateTime ldtEndTime=LocalDateTime.parse(r.getEndTime(), formatter);*/
		r.setDistance(10999l);
		return r;
	}
	
	

}
