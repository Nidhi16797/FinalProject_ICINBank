package com.icinbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icinbank.entity.UserProfileDetails;


@Repository
public interface UserProfileDetailsRepository extends JpaRepository<UserProfileDetails, String> {

}
