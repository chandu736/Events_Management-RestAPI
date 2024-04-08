package com.restapi.EventsFinderRestAPI.Repository;

import java.sql.Types;
import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreatorFactory;
import org.springframework.stereotype.Repository;
import com.restapi.EventsFinderRestAPI.Exception.DatabaseOperationException;
import com.restapi.EventsFinderRestAPI.Model.EventData;

@Repository
public class EventRepository {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public List<EventData> getEvents(double latitude, double longitude, LocalDate startDate, int offset, int limit) {
        String query = "SELECT * FROM events_data WHERE date BETWEEN ? AND DATE_ADD(?, INTERVAL 14 DAY) ORDER BY date LIMIT ?, ?";
        
        try {
            return jdbcTemplate.query(new PreparedStatementCreatorFactory(query, Types.DATE, Types.DATE, Types.INTEGER, Types.INTEGER)
                .newPreparedStatementCreator(new Object[]{startDate, startDate, offset, limit}), 
                (rs, rowNum) -> {
                    EventData eventData = new EventData();
                    eventData.setEventName(rs.getString("eventName"));
                    eventData.setCityName(rs.getString("cityName"));
                    eventData.setDate(rs.getDate("date").toLocalDate());
                    eventData.setLatitude(rs.getDouble("latitude"));
                    eventData.setLongitude(rs.getDouble("longitude"));
                    return eventData;
                });
        } catch (Exception e) {
            throw new DatabaseOperationException("Error while executing database operation.");
        }
    }
	
	public int getTotalEvents(double latitude, double longitude, LocalDate startDate) {
		String query="SELECT COUNT(*) FROM events_data WHERE date BETWEEN ? AND DATE_ADD(?,INTERVAL 14 DAY)";
		try {
			return jdbcTemplate.queryForObject(query, Integer.class, startDate, startDate);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new DatabaseOperationException("Error while executing database operation.");
		}
	}
}
