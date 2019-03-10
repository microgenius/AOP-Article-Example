package com.aop.article.example.service;

import com.aop.article.example.dto.customer.CreateCustomerRequest;
import com.aop.article.example.dto.customer.Customer;
import com.aop.article.example.service.type.ICustomerService;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceImpl implements ICustomerService {
  @Override
  public Customer create(CreateCustomerRequest createCustomerRequest) {
    //Müşteri verisi oluştur ve oluşturulan müşteriyi cache içerisine at
    return new Customer();
  }
}
