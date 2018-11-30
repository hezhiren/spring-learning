package cn.hzr.jndi.dao;

import cn.hzr.jndi.entity.User;
/**
 * hezhi
 * 2018/11/29 11:41
 */
public interface UserDao {

    User findUserByName(String name);

}
