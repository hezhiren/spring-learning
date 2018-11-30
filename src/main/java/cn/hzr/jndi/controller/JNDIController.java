package cn.hzr.jndi.controller;

import cn.hzr.jndi.dao.UserDao;
import cn.hzr.jndi.entity.User;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * hezhi
 * 2018/11/29 11:20
 */
@Controller
@RequestMapping("/jndi")
public class JNDIController {
    @Autowired
    private UserDao userDao;

    @RequestMapping(value = "/testConnect.do/{name}")
    @ResponseBody
    public JSONObject testConnect(@PathVariable String name) throws Exception{
        User user = userDao.findUserByName(name);
        System.out.println(user.toString());
        return JSONObject.parseObject(user.toString());
    }


}
