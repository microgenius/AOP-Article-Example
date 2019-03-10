package com.aop.article.example.dto.customer;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CreateCustomerRequest {
  private String name;
  private String surname;
  private LocalDate birthDate;
}
