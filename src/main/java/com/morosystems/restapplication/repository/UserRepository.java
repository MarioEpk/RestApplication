package com.morosystems.restapplication.repository;

import com.morosystems.restapplication.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface UserRepository extends CrudRepository<UserEntity, Integer> {


}