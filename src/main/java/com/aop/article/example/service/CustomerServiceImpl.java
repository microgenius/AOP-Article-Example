package com.aop.article.example.service;

import com.aop.article.example.aspect.component.CacheMethodData;
import com.aop.article.example.dto.customer.CreateCustomerRequest;
import com.aop.article.example.dto.customer.Customer;
import com.aop.article.example.service.type.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
  @Override
  @CacheMethodData
  public Customer create(CreateCustomerRequest createCustomerRequest) {
    //Müşteri verisi oluştur
    return new Customer();
  }
}
