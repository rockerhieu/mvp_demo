package io.github.rockerhieu.temperaturedemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import io.github.rockerhieu.temperaturedemo.data.Temperature;
import java.util.Locale;

public class MainActivity extends AppCompatActivity implements MainView {
  View vLoading;
  View vRetry;
  TextView vError;
  TextView vTemperature;
  MainPresenter presenter;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    vLoading = findViewById(R.id.loading);
    vRetry = findViewById(R.id.retry);
    vError = (TextView) findViewById(R.id.error);
    vTemperature = (TextView) findViewById(R.id.temperature);
    vRetry.setOnClickListener(new View.OnClickListener() {
      @Override public void onClick(View view) {
        presenter.onRetryClick();
      }
    });

    presenter = new MainPresenterImpl();
    presenter.setView(this);
  }

  @Override protected void onResume() {
    super.onResume();
    presenter.onResume();
  }

  @Override public void showLoading() {
    vLoading.setVisibility(View.VISIBLE);
  }

  @Override public void hideTemperature() {
    vTemperature.setVisibility(View.GONE);
  }

  @Override public void hideError() {
    vError.setVisibility(View.GONE);
    vRetry.setVisibility(View.GONE);
  }

  @Override public void hideLoading() {
    vLoading.setVisibility(View.GONE);
  }

  @Override public void showTemperature() {
    vTemperature.setVisibility(View.VISIBLE);
  }

  @Override public void showError() {
    vError.setVisibility(View.VISIBLE);
    vRetry.setVisibility(View.VISIBLE);
  }

  @Override public void setTemperature(Temperature temperature) {
    vTemperature.setText(String.format(Locale.US, "%.1f°C", temperature.getTemperature()));
  }

  @Override public void setError(Throwable error) {
    vError.setText(error.getMessage());
  }
}
