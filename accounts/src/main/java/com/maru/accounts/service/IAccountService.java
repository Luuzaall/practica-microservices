package com.maru.accounts.service;

import com.maru.accounts.DTO.CustomerDto;

public interface IAccountService {
    /**
     *
     * @param customerDto - the customer dto object
     */
    void createAccount(CustomerDto customerDto);
    /**
     *
     * @param mobileNumber - Input mobile number
     * @return boolean indicating if the update of Account details is successful or not
     */
    CustomerDto fetchAccount(String mobileNumber);

    /**
     *
     * @param customerDto - the customer dto object
     * @return boolean indicating if the update of the account is successful or not
     */
    boolean updateAccount(CustomerDto customerDto);


    /**
     *
     * @param mobileNumber - Input mobile number
     * @return boolean indicating if the delete of the account is successful or not
     */
    boolean deleteAccount(String mobileNumber);

}
