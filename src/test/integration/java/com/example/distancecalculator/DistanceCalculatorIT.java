package com.example.distancecalculator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistanceCalculatorIT {

  private final ByteArrayOutputStream printedContent = new ByteArrayOutputStream();
  @Autowired
  private DistanceCalculatorApplication distanceCalculatorApplication;
  private PrintStream printStream;

  @Before
  public void setUp() {
    printStream = System.out;
    System.setOut(new PrintStream(printedContent));
  }

  @After
  public void tearDown() {
    System.setOut(printStream);
  }

  @Test
  public void testSuccessIsLogged() {
    String[] args = {"src/test/resources/customers.txt"};
    distanceCalculatorApplication.run(args);

    //assert customers within distance have been printed
    assertTrue(printedContent.toString().contains("Id: 23, Name: Eoin Gallagher"));
    assertTrue(printedContent.toString().contains("Id: 30, Name: Nick Enright"));

    //assert print order is correct
    String[] splitString = printedContent.toString().split(",", 2);
    assertTrue(splitString[0].contains("Id: 23"));
    assertTrue(splitString[1].contains("Id: 30"));

    //assert customers not within distance have not been printed
    assertFalse(printedContent.toString().contains("Id: 25, Name: David Behan"));
  }

}
