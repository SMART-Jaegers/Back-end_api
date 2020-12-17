package com.sensycry.sensycry_api.service;

import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

public interface GeneralService<T, ID> {
    
    List<T> getEntities();
    
    @Transactional
    T getEntity(ID id);
    
    @Transactional
    T createEntity(T entity);
    
    @Transactional
    T updateEntity(T entity, ID id);
    
    @Transactional
    T deleteEntity(ID id);
    
    
}
