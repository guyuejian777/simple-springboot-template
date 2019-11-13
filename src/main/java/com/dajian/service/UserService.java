package com.dajian.service;

import com.dajian.entity.User;

public interface UserService extends BaseService<User> {
    User findByName(String name);
}
