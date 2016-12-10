package io.github.rockerhieu.temperaturedemo.data;

/**
 * Created by rockerhieu on 12/10/16.
 */
public interface Callback<Result> {
  void onSuccess(Result result);

  void onError(Throwable error);
}
