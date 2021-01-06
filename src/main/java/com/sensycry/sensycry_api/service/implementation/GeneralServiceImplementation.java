package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.service.GeneralService;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public abstract class GeneralServiceImplementation<T, ID> implements GeneralService<T, ID> {

  protected abstract JpaRepository<T, ID> getRepository();

  protected abstract void throwException();

  protected abstract T mergeEntities(T newEntity, T entity);

  @Override
  public List<T> getEntities() {
    return getRepository().findAll();
  }

  @Override
  public T getEntity(ID id) {
    if (getRepository().existsById(id)) {
      return getRepository().findById(id).get();
    }
    throwException();
    return null;
  }

  @Override
  public T createEntity(T entity) {
    return getRepository().save(entity);
  }

  @Override
  public T updateEntity(T entity, ID id) {
    if (getRepository().existsById(id)) {
      T newEntity = getRepository().findById(id).get();
      return getRepository().save(mergeEntities(newEntity, entity));
    }
    throwException();
    return null;
  }

  @Override
  public T deleteEntity(ID id) {
    if (getRepository().existsById(id)) {
      T entity = getRepository().findById(id).get();
      getRepository().deleteById(id);
      return entity;
    }
    throwException();
    return null;
  }
}
