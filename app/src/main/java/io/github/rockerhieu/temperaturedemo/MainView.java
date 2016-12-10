package io.github.rockerhieu.temperaturedemo;

import io.github.rockerhieu.temperaturedemo.data.Temperature;

/**
 * Created by rockerhieu on 12/10/16.
 */

public interface MainView {
  void showLoading();

  void hideTemperature();

  void hideError();

  void hideLoading();

  void showTemperature();

  void showError();

  void setTemperature(Temperature temperature);

  void setError(Throwable error);
}

