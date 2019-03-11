package com.aop.article.example.service.type;

import com.aop.article.example.dto.customer.CreateCustomerRequest;
import com.aop.article.example.dto.customer.Customer;

public interface ICustomerService {
  Customer create(CreateCustomerRequest createCustomerRequest);
}
