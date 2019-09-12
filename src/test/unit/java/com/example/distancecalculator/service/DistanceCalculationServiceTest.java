package com.example.distancecalculator.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DistanceCalculationServiceTest {

  @Autowired
  private DistanceCalculationService distanceCalculationService;

  @Test
  public void isWithinDistanceLimit() {
    assertTrue(distanceCalculationService.isWithinDistanceLimit(52.986375, -6.043701));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(54.0894797, -6.18671));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.038056, -7.653889));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.1229599, -6.2705202));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.2451022, -6.238335));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.1302756, -6.2397222));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.008769, -6.1056711));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.1489345, -6.8422408));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53, -7));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(52.966, -6.463));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(54.180238, -5.920898));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.0033946, -6.3877505));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(54.133333, -6.433333));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.74452, -7.11167));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.761389, -7.2875));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(54.080556, -6.361944));

    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.9529, -7.1249));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(53.6529, -7.5249));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(52.9123, -6.91243));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(52.7529, -6.49230));
    assertTrue(distanceCalculationService.isWithinDistanceLimit(52.4529, -6.01245));
  }

  @Test
  public void isNotWithinDistanceLimit() {
    assertFalse(distanceCalculationService.isWithinDistanceLimit(51.92893, -10.27699));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(51.8856167, -10.4240951));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(52.3191841, -8.5072391));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(53.807778, -7.714444));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(53.4692815, -9.436036));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(54.1225, -8.143333));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(52.2559432, -7.1048927));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(52.240382, -6.972413));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(51.999447, -9.742744));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(52.366037, -8.179118));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(52.228056, -7.915833));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(55.033, -8.112));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(53.521111, -9.831111));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(51.802, -9.442));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(54.374208, -8.371639));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(52.833502, -8.522366));

    assertFalse(distanceCalculationService.isWithinDistanceLimit(6.2032, -1.0923));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(60.8234, 22.0123457));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(0, 0));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(-72.2589, -55.7230));
    assertFalse(distanceCalculationService.isWithinDistanceLimit(51.9123, -5.91243));
  }

}
