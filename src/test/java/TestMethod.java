import cn.duan.domain.User;
import cn.duan.services.UserServices;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestMethod {
    @Test
    public void queryAll(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserServices userService = (UserServices) ctx.getBean("userService");
        List<User> users = userService.queryAll();
        for (User user: users) {
            System.out.println(users);
        }
    }
}
