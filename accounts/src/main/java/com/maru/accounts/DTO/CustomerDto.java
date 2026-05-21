package com.maru.accounts.DTO;

import lombok.Data;

// Acá utilizamos arroba Data y no en Account porque da problemas para las clases del tipo entidadwwwwww
@Data
public class CustomerDto {
    private String name;

    private String email;

    private String mobileNumber;

    private AccountDto accountDto;
}
