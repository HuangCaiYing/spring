package com.abc.service.impl;

import com.abc.common.Res;
import com.abc.common.ResEnum;
import com.abc.dao.entity.User;

import com.abc.dao.UserDao;
import com.abc.service.iservice.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements IUserService {
   @Autowired
   UserDao userDeo;


    @Override
    public Res userExist(String username) {
        int flag=0;
        try {
            flag=userDeo.exist(username);
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag>0?Res.success(ResEnum.SUCCESS_USER_EXIST):Res.error(ResEnum.ERROR_USER_EXIST);
    }

    @Override
    public Res<User> login(User user) {
           User result=null;
           try {
               result=userDeo.login(user);
           }catch (Exception e){
               e.printStackTrace();
           }
           if(result != null){
               result.setPassword("");
               return Res.success(ResEnum.SUCCESS,result);
           }
        return Res.error(ResEnum.ERROR);
    }


}
