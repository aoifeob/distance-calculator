package com.example.distancecalculator.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import com.example.distancecalculator.model.Customer;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JSONTransformerServiceTest {

  @Autowired
  private JSONTransformerService jsonTransformerService;

  @Test
  public void convertJsonToCustomer() {
    Customer customer = jsonTransformerService.convertJsonToCustomer(
        "{\"latitude\": \"52.833502\", \"user_id\": 25, \"name\": \"David Behan\", \"longitude\": \"-8.522366\"}");
    assertEquals(25, customer.getId());
    assertEquals("David Behan", customer.getName());
    assertEquals(52.833502, customer.getLatitude(), 0);
    assertEquals(-8.522366, customer.getLongitude(), 0);
  }

  @Test
  public void convertInvalidJsonToCustomer() {
    Customer customer = jsonTransformerService.convertJsonToCustomer("{\"abcd\": \"lkasd\"}");
    assertNull(customer);
  }

  @Test
  public void convertJsonToCustomerWhereNameIsNull() {
    Customer customer = jsonTransformerService.convertJsonToCustomer(
        "{\"latitude\": \"52.833502\", \"user_id\": 25, \"name\": null, \"longitude\": \"-8.522366\"}");
    assertNull(customer);
  }

}
