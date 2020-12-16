package com.abc.dao.idao;

import com.abc.dao.entity.User;

public interface IUserDeo {
    int exist(String username) throws Exception;

    User login(User user) throws Exception;
}
