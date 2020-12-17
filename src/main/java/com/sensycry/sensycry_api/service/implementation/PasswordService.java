package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.Password;
import com.sensycry.sensycry_api.exeption.NoSuchPasswordException;
import com.sensycry.sensycry_api.repository.PasswordRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class PasswordService extends GeneralServiceImplementation<Password, Integer> {
    
    private final PasswordRepository passwordRepository;
    
    public PasswordService(PasswordRepository passwordRepository) {
        this.passwordRepository = passwordRepository;
    }
    
    @Override
    protected JpaRepository<Password, Integer> getRepository() {
        return passwordRepository;
    }
    
    @Override
    protected void throwException() {
        throw new NoSuchPasswordException();
    }
    
    @Override
    protected Password mergeEntities(Password newEntity, Password entity) {
        newEntity.setPassword(
            entity.getPassword() != null ? entity.getPassword() : newEntity.getPassword());
        return newEntity;
    }
}
