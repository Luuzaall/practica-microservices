package com.maru.accounts.service;

import com.maru.accounts.DTO.CustomerDto;

public interface IAccountService {
    /**
     *
     * @param customerDto - the customer dto object
     */
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
}
