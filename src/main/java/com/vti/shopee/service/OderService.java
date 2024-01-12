package com.vti.shopee.service;

import com.vti.shopee.config.exception.AppException;
import com.vti.shopee.config.exception.ErrorResponseEnum;
import com.vti.shopee.modal.dto.OderCreateRequestDto;
import com.vti.shopee.modal.entity.Account;
import com.vti.shopee.modal.entity.Oder;
import com.vti.shopee.modal.entity.Product;
import com.vti.shopee.modal.entity.Status;
import com.vti.shopee.repository.AccountRepository;
import com.vti.shopee.repository.OderRepository;
import com.vti.shopee.repository.ProductRepository;
import com.vti.shopee.service.iml.IMailSenderService;
import com.vti.shopee.service.iml.IOderService;
import lombok.AllArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service

public class OderService implements IOderService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private OderRepository oderRepository;

    @Autowired
    private IMailSenderService iMailSenderService;

    @Override
    public Oder create(OderCreateRequestDto dto) {
        Optional<Account> optionalAccount = accountRepository.findById(dto.getAccountId());
        if (optionalAccount.isEmpty()){
            throw new AppException(ErrorResponseEnum.NOT_FOUND_ACCOUNT);
        }
        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
        if (optionalProduct.isEmpty()){
            throw new AppException(ErrorResponseEnum.NOT_FOUND_PRODUCT);
        }
        Account account = optionalAccount.get();
            Product product = optionalProduct.get();

            Oder order = new Oder();
            order.setAccount(account);
            order.setProduct(product);
            order.setQuantity(dto.getQuantity());
            order.setStatus(Status.PENDING);
            return oderRepository.save(order);
            //cach khac
//        Optional<Account> optionalAccount = accountRepository.findById(dto.getAccountId());
//        Optional<Product> optionalProduct = productRepository.findById(dto.getProductId());
//        if (optionalAccount.isPresent() && optionalProduct.isPresent()) {
//            Account account = optionalAccount.get();
//            Product product = optionalProduct.get();
//
//            Oder order = new Oder();
//            order.setAccount(account);
//            order.setProduct(product);
//            order.setQuantity(dto.getQuantity());
//            order.setStatus(Status.PENDING);
//            return oderRepository.save(order);
//        }
//        return null;
    }

    @Override
    public Oder buyProduct(int oderId) {
        Optional<Oder> oderOptional = oderRepository.findById(oderId);
        if (oderOptional.isPresent()) {

            Oder oder = oderOptional.get();
            oder.setStatus(Status.DONE);
            
            return oderRepository.save(oder);

        }
        return null;
    }

    @Override
    public Oder cancelOder(int oderId) {
        Optional<Oder> oderOptional = oderRepository.findById(oderId);

        if (oderOptional.isPresent()) {
            Oder oder = oderOptional.get();
            oder.setStatus(Status.CANCEL);
            return oderRepository.save(oder);
        }
        return null;
    }

    @Override
    public List<Oder> getAll() {

        return oderRepository.findAll();
    }

    @Override
    public List<Oder> findAllByStatus(Status status ,int accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        if (optionalAccount.isEmpty()) {
            throw new AppException(ErrorResponseEnum.NOT_FOUND_ACCOUNT);
        }
        if (status!=null) {
           return oderRepository.findAllByStatusAndAccount_Id(status, accountId);
        }else {
            return oderRepository.findAllByAccount_Id(accountId);
        }
    }
}