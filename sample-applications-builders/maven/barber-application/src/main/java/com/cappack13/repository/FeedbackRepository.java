package com.cappack13.repository;

import javax.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.cappack13.model.Feedback;

 

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer>,CrudRepository<Feedback, Integer>{
    
    //@Query(value = "SELECT AVG(feed_back) FROM feedback WHERE bid=?id",nativeQuery=true)
    @Query("SELECT AVG(f.feedBack) FROM Feedback f WHERE f.BId=:id")
    public Double getavgoffeedbackonbarber(int id);

 

}