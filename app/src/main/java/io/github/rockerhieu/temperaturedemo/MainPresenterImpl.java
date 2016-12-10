package io.github.rockerhieu.temperaturedemo;

import io.github.rockerhieu.temperaturedemo.api.TemperatureApi;
import io.github.rockerhieu.temperaturedemo.api.TemperatureApiImpl;
import io.github.rockerhieu.temperaturedemo.data.Callback;
import io.github.rockerhieu.temperaturedemo.data.Temperature;

/**
 * Created by rockerhieu on 12/10/16.
 */

public class MainPresenterImpl extends BasePresenter<MainView> implements MainPresenter {
  TemperatureApi temperatureApi;

  public MainPresenterImpl() {
    this(new TemperatureApiImpl());
  }

  public MainPresenterImpl(TemperatureApi temperatureApi) {
    this.temperatureApi = temperatureApi;
  }

  @Override public void onCreate() {
    fetchTemperatureInHcm();
  }

  @Override public void fetchTemperatureInHcm() {
    view.showLoading();
    view.hideTemperature();
    view.hideError();
    getTemperature("HCM");
  }

  @Override public void onRetryClick() {
    fetchTemperatureInHcm();
  }

  @Override public void onResume() {
    fetchTemperatureInHcm();
  }

  private void getTemperature(String address) {
    temperatureApi.getTemperature(address, new Callback<Temperature>() {
      @Override public void onSuccess(Temperature temperature) {
        onFetchTemperatureInHcmSuccess(temperature);
      }

      @Override public void onError(Throwable error) {
        onFetchTemperatureInHcmError(error);
      }
    });
  }

  private void onFetchTemperatureInHcmSuccess(Temperature temperature) {
    view.hideLoading();
    view.showTemperature();
    view.hideError();
    view.setTemperature(temperature);
  }

  private void onFetchTemperatureInHcmError(Throwable error) {
    view.hideLoading();
    view.hideTemperature();
    view.showError();
    view.setError(error);
  }
}
