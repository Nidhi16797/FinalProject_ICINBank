package com.icinbank.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icinbank.entity.AccountTransactionDetails;
import com.icinbank.entity.UserBankDetails;
import com.icinbank.repository.AccountTransactionDetailsRepository;
import com.icinbank.repository.UserBankDetailsRepository;

@Service
public class AccountDetailsService {

	@Autowired
	private UserBankDetailsRepository userBankDetailsRepository;

	@Autowired
	private AccountTransactionDetailsRepository atdRepository;

	/**
	 * This method is used to get the user account details identified by userId
	 * 
	 * @param userId
	 * @return
	 */
	@Transactional(readOnly = true, timeout = 50)
	public List<UserBankDetails> getUserAccountDetails(String userId) {
		return userBankDetailsRepository.getUserAccountDetails(userId);
	}

	/**
	 * This method is used to update account and transaction details
	 * when funds transfer is performed
	 * 
	 * @param sUserBankDetails
	 * @param dUserBankDetails
	 * @param sTransactionDetails
	 * @param dTransactionDetails
	 */
	@Transactional(rollbackFor = Exception.class, timeout = 50)
	public void transferFunds(UserBankDetails sUserBankDetails, UserBankDetails dUserBankDetails,
			AccountTransactionDetails sTransactionDetails, AccountTransactionDetails dTransactionDetails) {
		userBankDetailsRepository.save(sUserBankDetails);
		userBankDetailsRepository.save(dUserBankDetails);
		atdRepository.save(sTransactionDetails);
		atdRepository.save(dTransactionDetails);
	}

	/**
	 * This method is used to get the account transaction details
	 * for the account number between a period of time
	 * 
	 * @param accountNumber
	 * @param fromDate
	 * @param toDate
	 * @return
	 * @throws ParseException
	 */
	@Transactional(readOnly = true, timeout = 50)
	public List<AccountTransactionDetails> getAccountTransactionDetails(String accountNumber, String fromDate,
			String toDate) throws ParseException {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date fDate = dateFormat.parse(fromDate);
		Date tDate = dateFormat.parse(toDate);
		return atdRepository.findByAccountNumberAndUpdatedDateTimeBetween(accountNumber, fDate, tDate);
	}

}
