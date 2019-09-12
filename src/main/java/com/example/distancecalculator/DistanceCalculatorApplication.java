package com.example.distancecalculator;

import com.example.distancecalculator.model.Customer;
import com.example.distancecalculator.service.DistanceCalculationService;
import com.example.distancecalculator.service.JSONTransformerService;
import com.example.distancecalculator.util.FileReaderUtil;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DistanceCalculatorApplication implements CommandLineRunner {

  private FileReaderUtil fileReaderUtil;
  private JSONTransformerService jsonTransformerService;
  private DistanceCalculationService distanceCalculationService;

  @Autowired
  public DistanceCalculatorApplication(FileReaderUtil fileReaderUtil,
      JSONTransformerService jsonTransformerService,
      DistanceCalculationService distanceCalculationService) {
    this.fileReaderUtil = fileReaderUtil;
    this.jsonTransformerService = jsonTransformerService;
    this.distanceCalculationService = distanceCalculationService;
  }

  public static void main(String[] args) {
    SpringApplication.run(DistanceCalculatorApplication.class, args);
  }

  @Override
  public void run(String[] args) {

    List<String> argsList = Arrays.stream(args).collect(Collectors.toList());

    for (String itemInList : argsList) {
      fileReaderUtil.readFile(itemInList)
          .stream()
          .map(jsonTransformerService::convertJsonToCustomer)
          .filter(Objects::nonNull)
          .filter(c -> distanceCalculationService
              .isWithinDistanceLimit(c.getLatitude(), c.getLongitude()))
          .sorted(Comparator.comparing(Customer::getId))
          .forEach(c -> System.out.println("Id: " + c.getId() + ", Name: " + c.getName()));
    }
  }

}
