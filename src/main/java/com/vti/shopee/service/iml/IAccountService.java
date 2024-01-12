package com.vti.shopee.service.iml;

import com.vti.shopee.modal.dto.AccountCreateDto;
import com.vti.shopee.modal.dto.AccountUpdate;
import com.vti.shopee.modal.dto.BaseRequest;
import com.vti.shopee.modal.entity.Account;
import com.vti.shopee.modal.entity.Product;
import org.springframework.data.domain.Page;

import java.util.List;

public interface IAccountService {
    List<Account> getAll();



    Account createAccount(AccountCreateDto account);

    Account getById(int id);

    Account updateAccount(AccountUpdate dto);

    void deleteAccount(int id);

}
