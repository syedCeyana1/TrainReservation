package com.ra.trainBooking;


import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.Assert;

import com.ra.trainBooking.DTO.ReservationDTO;
import com.ra.trainBooking.DTO.UserRegisteredDTO;
import com.ra.trainBooking.model.TrainData;
import com.ra.trainBooking.repository.TrainDataRepository;
import com.ra.trainBooking.repository.UserRepository;
import com.ra.trainBooking.service.DefaultUserService;

@SpringBootTest
class TrainBookingSystemApplicationTests {

	@Autowired
	DefaultUserService userService;
	@Autowired
	UserRepository userRepo;
	@Autowired
	TrainDataRepository trainDataRepository;

	
	@Test
	public void registerAndLoginWithUserAccount() {
		UserRegisteredDTO userRegisteredDTO = new UserRegisteredDTO();
		userRegisteredDTO.setEmail_id("temp@gmail.com");
		userRegisteredDTO.setName("Temp");
		userRegisteredDTO.setPassword("12345");
		userRegisteredDTO.setRole("USER");
		userService.save(userRegisteredDTO);
		Assert.notNull(userRepo.findByEmail("temp@gmail.com"), "User found in DB");
		UserDetails user = userService.loadUserByUsername("temp@gmail.com");
		Assert.notNull(user, "Logined successfully");
	}
	
	@Test
	public void registerAndLoginAdminAccount() {
		UserRegisteredDTO userRegisteredDTO = new UserRegisteredDTO();
		userRegisteredDTO.setName("ABC");
		userRegisteredDTO.setEmail_id("temp1@gmail.com");
		userRegisteredDTO.setPassword("12345");
		userRegisteredDTO.setRole("ADMIN");
		userService.save(userRegisteredDTO);
		Assert.notNull(userRepo.findByEmail("temp1@gmail.com"), "Register successful");
		UserDetails user = userService.loadUserByUsername("temp1@gmail.com");
		Assert.notNull(user, "User Login Successful");
	} 
	
	
	@Test
	public void saveTrainDataByAdminAccount() {
		UserRegisteredDTO userRegisteredDTO = new UserRegisteredDTO();
		userRegisteredDTO.setName("ABC");
		userRegisteredDTO.setEmail_id("temp12@gmail.com");
		userRegisteredDTO.setPassword("12345");
		userRegisteredDTO.setRole("ADMIN");
		userService.save(userRegisteredDTO);
		Assert.notNull(userRepo.findByEmail("temp12@gmail.com"), "Register successful");
		UserDetails user = userService.loadUserByUsername("temp12@gmail.com");
		Assert.notNull(user, "User Login Successful");
		TrainData trainData = new TrainData();
		trainData.setTrainName("TestTrain");
		trainData.setFromDestination("ND");
		trainData.setToDestination("AMT");
		trainData.setFilterDate("2022-11-10");
		trainData.setTime("11:25");
		trainData.setPrice(40.0);
		TrainData bs = trainDataRepository.save(trainData);
		Assert.notNull(bs, "Traindata Saved Successfully");
	} 

	
	@Test
	public void fetchTrainData() {
		ReservationDTO rs = new ReservationDTO();
		rs.setFrom("ND");
		rs.setTo("AMT");
		rs.setFilterDate("2022-11-10");
		List<TrainData> bs = trainDataRepository.findByToFromAndDate(rs.getTo(), rs.getFrom(), rs.getFilterDate());
		Assert.notEmpty(bs, "Train Data available with above filters ");
	}
	 
}
