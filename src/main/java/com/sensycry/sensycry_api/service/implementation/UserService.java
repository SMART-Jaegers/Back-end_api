package com.sensycry.sensycry_api.service.implementation;

import com.sensycry.sensycry_api.domain.User;
import com.sensycry.sensycry_api.exeption.NoSuchUserException;
import com.sensycry.sensycry_api.repository.UserRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GeneralServiceImplementation<User, Integer> {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @Override
  protected JpaRepository<User, Integer> getRepository() {
    return userRepository;
  }

  @Override
  protected void throwException() {
    throw new NoSuchUserException();
  }

  @Override
  protected User mergeEntities(User newEntity, User entity) {

    newEntity.setUsername(
        entity.getUsername() != null ? entity.getUsername() : newEntity.getUsername());
    newEntity.setEmail(entity.getEmail() != null ? entity.getEmail() : newEntity.getEmail());
    return newEntity;
  }
}
