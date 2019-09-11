package com.example.distancecalculator.service;

import com.example.distancecalculator.model.Customer;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class JSONTransformerService {

  private ObjectMapper mapper = new ObjectMapper();

  public Customer convertJsonToCustomer(String json) {
    try {
      return mapper.readValue(json, Customer.class);
    } catch (Exception e) {
      log.error("Error creating customer object from json: ", e);
      return null;
    }
  }

}
