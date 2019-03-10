package com.aop.article.example.dto.result;

import lombok.Data;

@Data
public class DataResult<D> extends Result {
  private D data;
}
