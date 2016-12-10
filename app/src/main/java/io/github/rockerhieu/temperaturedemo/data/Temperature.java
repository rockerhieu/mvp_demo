package io.github.rockerhieu.temperaturedemo.data;

/**
 * Created by rockerhieu on 12/10/16.
 */
public class Temperature {
  String address;
  double temperature;

  public Temperature(String address, double temperature) {
    this.address = address;
    this.temperature = temperature;
  }

  public String getAddress() {
    return address;
  }

  public double getTemperature() {
    return temperature;
  }
}
