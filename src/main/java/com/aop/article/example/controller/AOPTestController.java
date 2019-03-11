package com.aop.article.example.controller;

import com.aop.article.example.aspect.component.*;
import com.aop.article.example.dto.customer.CreateCustomerRequest;
import com.aop.article.example.dto.customer.CreateCustomerResult;
import com.aop.article.example.dto.customer.Customer;
import com.aop.article.example.service.type.ICustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController("/aop") // Spring Controller annotation
public class AOPTestController {
  private static final Logger logger = LoggerFactory.getLogger(AOPTestController.class);

  private final ICustomerService customerService;

  @Autowired //Dependency Injection
  public AOPTestController(ICustomerService customerService) {
    this.customerService = customerService;
  }

  @PostMapping(path = "/create/wo/customer")
  public CreateCustomerResult createCustomerWOAspect(@RequestBody CreateCustomerRequest createCustomerRequest) {
    final CreateCustomerResult result = new CreateCustomerResult();
    final StopWatch methodTimer = new StopWatch();

    try {
      //Analitik verisi topla

      //Login olan kullanıcıyı bul ve method yetkisini kontrol et

      //Request'i logla
      logger.info("Method Request, [Method]: createCustomer, [Request]: {}", createCustomerRequest);

      methodTimer.start();

      //Müşteri verisi oluştur
      final Customer newCustomer = customerService.create(createCustomerRequest);

      result.setCompleted(true);
      result.setData(newCustomer.getRecordId());
    } catch (Exception e) {
      //Özel hata yakalama durumları (Exception türüne göre davranış)
      result.setCompleted(false);
      result.setMessage("Error");
    } finally {
      methodTimer.stop();

      //Log method performance
      logger.info("Method execution has finished, [Method]: createCustomer, [TotalTime]: {}", methodTimer.getTotalTimeMillis());
    }

    //Response'yi logla
    logger.info("Method Response, [Method]: createCustomer, [Response]: {}", result);

    return result;
  }

  @EventAnalytic
  @AuthorizedRequest
  @LogMethodData(logField = {
      LogMethodTypeValues.REQUEST,
      LogMethodTypeValues.RESPONSE
  })
  @HandleException(responseType = CreateCustomerResult.class)
  @LogMethodPerformance
  @PostMapping(path = "/create/w/customer")
  public CreateCustomerResult createCustomerWAspect(@RequestBody CreateCustomerRequest createCustomerRequest){
    final CreateCustomerResult result = new CreateCustomerResult();
    final Customer newCustomer = customerService.create(createCustomerRequest);

    result.setCompleted(true);
    result.setData(newCustomer.getRecordId());

    return result;
  }
}
