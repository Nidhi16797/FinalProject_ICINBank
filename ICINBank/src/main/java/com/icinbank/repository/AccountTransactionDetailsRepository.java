package com.icinbank.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.icinbank.entity.AccountTransactionDetails;


@Repository
public interface AccountTransactionDetailsRepository extends JpaRepository<AccountTransactionDetails, Integer> {

	List<AccountTransactionDetails> findByAccountNumberAndUpdatedDateTimeBetween(String accountNumber, Date fromDate,
			Date toDate);

}
