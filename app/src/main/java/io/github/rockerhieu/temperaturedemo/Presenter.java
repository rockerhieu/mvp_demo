package io.github.rockerhieu.temperaturedemo;

/**
 * Created by rockerhieu on 12/10/16.
 */

public interface Presenter<View> {
  View getView();

  void setView(View view);
}
