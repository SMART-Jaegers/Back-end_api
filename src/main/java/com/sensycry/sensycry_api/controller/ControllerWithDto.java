package com.sensycry.sensycry_api.controller;

import java.util.List;

public interface ControllerWithDto<T, S> {
  List<T> createDtos(Iterable<S> entities);

  T createDto(S entity);
}
