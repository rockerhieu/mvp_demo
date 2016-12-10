package io.github.rockerhieu.temperaturedemo;

/**
 * Created by rockerhieu on 12/10/16.
 */
public class BasePresenter<View> implements Presenter<View> {
  View view;

  @Override public View getView() {
    return view;
  }

  @Override public void setView(View view) {
    this.view = view;
  }
}
