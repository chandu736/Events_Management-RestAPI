package com.restapi.EventsFinderRestAPI.Repository;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restapi.EventsFinderRestAPI.Model.EventData;
@Repository
public interface EventRepository extends JpaRepository<EventData,Serializable> {
	List<EventData> findByDateBetween(LocalDate startDate,LocalDate endDate);
}
