package io.github.rockerhieu.temperaturedemo.api;

import android.os.AsyncTask;
import io.github.rockerhieu.temperaturedemo.data.Callback;

/**
 * Created by rockerhieu on 12/10/16.
 */

public abstract class BaseApi {
  protected <Result> void executeAsync(final Task<Result> task, final Callback<Result> callback) {
    new AsyncTask<Void, Void, Result>() {
      Throwable cause;

      @Override protected Result doInBackground(Void... voids) {
        try {
          return task.excute();
        } catch (Throwable e) {
          cause = e;
        }
        return null;
      }

      @Override protected void onPostExecute(Result result) {
        super.onPostExecute(result);
        if (result != null) {
          callback.onSuccess(result);
        } else {
          callback.onError(cause);
        }
      }
    }.execute();
  }
}
