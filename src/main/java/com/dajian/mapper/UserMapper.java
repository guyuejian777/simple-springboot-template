package com.dajian.mapper;

import com.dajian.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {
    List<User> findAll();

    void update(User user);

    void delete(Long id);

    void create(User user);

    List<User> findById(Long id);

    User findByName(String name);
}
