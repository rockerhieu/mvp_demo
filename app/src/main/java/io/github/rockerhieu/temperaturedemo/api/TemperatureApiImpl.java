package io.github.rockerhieu.temperaturedemo.api;

import android.text.TextUtils;
import io.github.rockerhieu.temperaturedemo.data.Callback;
import io.github.rockerhieu.temperaturedemo.data.Temperature;
import java.util.Random;

/**
 * Created by rockerhieu on 12/10/16.
 */
public class TemperatureApiImpl extends BaseApi implements TemperatureApi {
  private Random random;

  public TemperatureApiImpl() {
    random = new Random();
  }

  @Override public void getTemperature(final String address, final Callback<Temperature> callback) {
    executeAsync(new Task<Temperature>() {
      @Override public Temperature excute() throws Throwable {
        Thread.sleep(3000);
        if (random.nextBoolean()) {
          throw new RuntimeException("Đã có lỗi xảy ra, vui lòng thử lại");
        }
        if (TextUtils.equals(address, "HCM")) {
          return new Temperature(address, 20 + random.nextInt(11));
        } else if (TextUtils.equals(address, "SF")) {
          return new Temperature(address, 10 + random.nextInt(6));
        } else {
          return new Temperature(address, 50);
        }
      }
    }, callback);
  }
}
