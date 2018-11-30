package cn.hzr.jndi.controller;

import cn.hzr.jndi.dao.UserDao;
import cn.hzr.jndi.entity.User;
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

    /**
     * 返回String字符串，会存在中文编码问题，需要在spring-mvc.xml配合字符集
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testConnect.do/{name}")
    @ResponseBody
    public String testConnect(@PathVariable String name) throws Exception{
        User user = userDao.findUserByName(name);
        return user.toString();
    }

    /**
     * json 数据格式返回的中文编码是正常的
     * @param name
     * @return
     * @throws Exception
     */
    @RequestMapping(value = "/testJson.do/{name}")
    @ResponseBody
    public JSONObject testJson(@PathVariable String name) throws Exception{
        User user = userDao.findUserByName(name);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("user", user);
        return jsonObject;
    }


}
