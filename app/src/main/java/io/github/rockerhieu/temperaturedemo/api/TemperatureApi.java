package io.github.rockerhieu.temperaturedemo.api;

import io.github.rockerhieu.temperaturedemo.data.Callback;
import io.github.rockerhieu.temperaturedemo.data.Temperature;

/**
 * Created by rockerhieu on 12/10/16.
 */
public interface TemperatureApi {
  void getTemperature(String address, Callback<Temperature> callback);
}
