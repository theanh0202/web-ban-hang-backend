package com.vti.shopee.service;

import com.vti.shopee.config.exception.AppException;
import com.vti.shopee.config.exception.ErrorResponseEnum;
import com.vti.shopee.modal.dto.AccountCreateDto;
import com.vti.shopee.modal.dto.AccountUpdate;
import com.vti.shopee.modal.entity.Account;
import com.vti.shopee.modal.entity.Role;
import com.vti.shopee.repository.AccountRepository;
import com.vti.shopee.service.iml.IAccountService;
import com.vti.shopee.service.iml.IMailSenderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService , UserDetailsService {

    final private AccountRepository accountRepository;

    @Autowired
    private IMailSenderService iMailSenderService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @Override
    public Account createAccount(AccountCreateDto dto) {
        Account account=new Account();
        BeanUtils.copyProperties(dto,account);
        String pwEncoder= passwordEncoder.encode(dto.getPassword());
        account.setPassword(pwEncoder);
        account.setRole(Role.CUSTOMER);
        String text="BAN VỪA TẠO TÀI KHOẢN"+dto.getName()+"ĐỂ KÍCH HOẠT TÀI KHOẢN CLICK ";

        iMailSenderService.sendSimpleMessage(dto.getEmail(), "kich hoạt tài khoản",""+dto.getName());
        return accountRepository.save(account);
    }

    @Override
    public Account getById(int id) {
    Optional<Account> accountOptional=accountRepository.findById(id);
    if (accountOptional.isPresent()){
        return accountOptional.get();
    }else {
        return null;
    }
    }

    @Override
    public Account updateAccount(AccountUpdate dto) {
        Optional<Account> optionalAccount=accountRepository.findById(dto.getId());
        if (optionalAccount.isPresent()){
            Account account= optionalAccount.get();
            BeanUtils.copyProperties(dto,account);
            return accountRepository.save(account);
        }else {
            throw new AppException(ErrorResponseEnum.NOT_FOUND_ACCOUNT);
        }

    }

    @Override
    public void deleteAccount(int id) {
        try{
            accountRepository.deleteById(id);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            Account account=new Account();
            iMailSenderService.sendSimpleMessage(account.getEmail(), "khong the xoa tai khoan co ",""+id);
        }
    }

    /**
     * dung để spring security kiểm tra user name có tồn tại trong hệ thông hay không
     * @param username
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Account> accountOptional =accountRepository.findByName(username);
        /**NẾU account đã tồn tại ->tao ra đối tương userdetail
         *account.getName() :usẻrname
         * account.getPassword(): password dda duwocj ma hoa
         * authorites : danh sach quyen cau user
         */
        if (accountOptional.isPresent()){
            Account account= accountOptional.get();
            List<GrantedAuthority> authorities =new ArrayList<>();
            authorities.add(account.getRole());
            return new User(account.getName(), account.getPassword(), authorities );
        }
        throw new UsernameNotFoundException(username);
    }
}
