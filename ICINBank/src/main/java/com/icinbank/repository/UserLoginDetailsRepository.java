package com.icinbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.icinbank.entity.UserLoginDetails;


@Repository
public interface UserLoginDetailsRepository extends JpaRepository<UserLoginDetails, String> {

	@Query(value = "select a.* from user_login_details a, user_bank_details b "
			+ "where a.user_id = b.user_id and a.user_id = :userId and a.password= :password "
			, nativeQuery = true)
	UserLoginDetails findByUserIdAndPasswordAndBank(@Param("userId") String userId, 
			@Param("password") String password);

}
