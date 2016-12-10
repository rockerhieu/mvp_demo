package io.github.rockerhieu.temperaturedemo.api;

/**
 * Created by rockerhieu on 12/10/16.
 */

public interface Task<Result> {
  Result excute() throws Throwable;
}
