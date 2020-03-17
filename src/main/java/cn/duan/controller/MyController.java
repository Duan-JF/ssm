package cn.duan.controller;

import cn.duan.domain.User;
import cn.duan.exception.MyUserException;
import cn.duan.exception.NameException;
import cn.duan.services.UserServices;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
public class MyController{
    @RequestMapping(value = "/some.do",method = RequestMethod.POST)
    public ModelAndView dosome(String name,String pwd) throws MyUserException {
        String config = "applicationContext.xml";
        ApplicationContext ctx = new ClassPathXmlApplicationContext(config);
        ModelAndView mv = new ModelAndView();
        mv.addObject("name",name);
        mv.addObject("pwd",pwd);
        UserServices userServices = (UserServices) ctx.getBean("userService");
        List<User> userList = userServices.queryAll();
        boolean flag = userServices.queryUser(name);
        if (!flag)
            throw new NameException("用户不存在，请重新输入");
        mv.addObject("list",userList);
        mv.setViewName("result");
        return mv;
    }
}
