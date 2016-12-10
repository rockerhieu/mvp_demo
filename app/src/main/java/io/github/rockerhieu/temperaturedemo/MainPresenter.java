package io.github.rockerhieu.temperaturedemo;

/**
 * Created by rockerhieu on 12/10/16.
 */

public interface MainPresenter extends Presenter<MainView> {
  void onCreate();

  void fetchTemperatureInHcm();

  void onRetryClick();

  void onResume();
}
