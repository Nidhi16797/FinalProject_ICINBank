package com.icinbank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icinbank.entity.UserAccountDetails;


@Repository
public interface UserAccountDetailsRepository extends JpaRepository<UserAccountDetails, String> {

}
