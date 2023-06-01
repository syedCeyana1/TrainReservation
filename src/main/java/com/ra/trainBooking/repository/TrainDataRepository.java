package com.ra.trainBooking.repository;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ra.trainBooking.DTO.BookingsDTO;
import com.ra.trainBooking.model.TrainData;

@Repository
public interface TrainDataRepository extends JpaRepository<TrainData, Integer>{
	@Query(value = "select * from Reservation  where reservation.to_destination =:to and reservation.from_destination =:from and reservation.filter_date =:date  order By reservation.filter_date desc " , nativeQuery = true)
	List<TrainData> findByToFromAndDate(String to , String from, String date);
	
	

}
