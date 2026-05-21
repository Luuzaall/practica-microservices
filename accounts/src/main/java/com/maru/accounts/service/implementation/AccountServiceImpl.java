package com.maru.accounts.service.implementation;

import com.maru.accounts.DTO.CustomerDto;
import com.maru.accounts.constants.AccountsConstants;
import com.maru.accounts.entity.Account;
import com.maru.accounts.entity.Customer;
import com.maru.accounts.exception.CustomerAlreadyExistException;
import com.maru.accounts.exception.ResourceNotFoundException;
import com.maru.accounts.mapper.CustomerMapper;
import com.maru.accounts.repository.AccountRepository;
import com.maru.accounts.repository.CustomerRepository;
import com.maru.accounts.service.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountService {

    private AccountRepository accountsRepository;
    private CustomerRepository customerRepository;
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());
        Optional<Customer> optCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());
        if (optCustomer.isPresent()) {
            throw new CustomerAlreadyExistException(
                    "Customer already registered with given mobile number: "+
                            customerDto.getMobileNumber());
        }

        customer.setCreatedAt(LocalDateTime.now());
        customer.setCreatedBy("El Mago");
        Customer savedCustomer = customerRepository.save(customer);
        accountsRepository.save(createNewAccount(savedCustomer));
    }

    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();

        newAccount.setCustomerId(customer.getCustomerId());
        /** generating random account number */
        long randomAccountNumber = 100000000L+new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccountNumber);
        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);

        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("El Mago");
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotFoundException("Customer", "mobile number", mobileNumber)
        );

        Account account = accountsRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotFoundException("Account", "customer id", customer.getCustomerId().toString())

        );

        CustomerMapper.mapToCustomer(new CustomerDto(), customer);
        return null;
    }

}
