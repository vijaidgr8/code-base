package com.cg.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cg.bean.User;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {
	
	@Query(value = "SELECT nextval('card_sequence')", nativeQuery = true)
    Long getNextSeriesId();

	// find user by userId
	public User findUserByUserId(String userId);
}
