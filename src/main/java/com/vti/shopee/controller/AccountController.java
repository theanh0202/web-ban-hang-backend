package com.vti.shopee.controller;

import com.vti.shopee.modal.dto.AccountCreateDto;
import com.vti.shopee.modal.dto.AccountUpdate;
import com.vti.shopee.modal.entity.Account;
import com.vti.shopee.modal.entity.Role;
import com.vti.shopee.service.AccountService;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/account")
@CrossOrigin("*")
@Slf4j
public class AccountController {

    @Autowired
    private AccountService accountService;

    @GetMapping("/get-all")
    public List<Account> getall(){
        log.info("get all account infor");
        log.warn("get all account warning");
        log.error("get all account err");
        return accountService.getAll();
    }

    @PostMapping("/create")
    public Account create(@RequestBody AccountCreateDto dto){
        return accountService.createAccount(dto);
    }

    @GetMapping("{id}")
    public Account getById(@PathVariable int id){
        return accountService.getById(id);
    }
    @PutMapping("/update")
    //http://localhost:8080/api/v1/account/update
    public Account update(@RequestBody AccountUpdate dto){
        return accountService.updateAccount(dto);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize(value = "hasAnyAuthority('ADMIN')")
    public void deleteAccount(@PathVariable int id){
        accountService.deleteAccount(id);
    }

}
