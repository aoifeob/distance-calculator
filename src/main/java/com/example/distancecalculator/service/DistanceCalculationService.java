package com.example.distancecalculator.service;

import org.springframework.stereotype.Service;

@Service
public class DistanceCalculationService {

  public static final int RADIUS_OF_EARTH = 6_360; //Value in km. The radius varies depending on latitude; we will take this value as an estimate
  public static final int DISTANCE_LIMIT = 100; //Value in km
  public static final double ORIGIN_LATITUDE = 53.339428; //Latitude of our origin point for comparison
  public static final double ORIGIN_LONGITUDE = -6.257664; //Longitude of our origin point for comparison

  public boolean isWithinDistanceLimit(double customerLatitudeDegrees,
      double customerLongitudeDegrees) {
    return getArcLength(getCentralAngle(convertDegreesToRadians(customerLatitudeDegrees),
        convertDegreesToRadians(customerLongitudeDegrees))) <= DISTANCE_LIMIT;
  }

  private double convertDegreesToRadians(double degrees) {
    return degrees * Math.PI / 180;
  }

  private double getCentralAngle(double customerLatitudeRadians, double customerLongitudeRadians) {
    return Math.acos(
        (Math.sin(convertDegreesToRadians(ORIGIN_LATITUDE)) * Math.sin(customerLatitudeRadians)) + (
            Math.cos(convertDegreesToRadians(ORIGIN_LATITUDE)) * Math
                .cos(customerLatitudeRadians) * Math
                .cos(Math.abs(
                    convertDegreesToRadians(ORIGIN_LONGITUDE) - customerLongitudeRadians))));
  }

  private double getArcLength(double centralAngle) {
    return RADIUS_OF_EARTH * centralAngle;
  }

}
