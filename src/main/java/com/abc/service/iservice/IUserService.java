package com.abc.service.iservice;

import com.abc.common.Res;
import com.abc.dao.entity.User;

public interface IUserService {
    //定义一个返回值的方法
    Res userExist(String username);

    Res<User> login(User user);
}
