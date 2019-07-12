package app.future.web.handler;

import app.future.commons.bean.Brand;
import app.future.commons.services.IBrandService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class TestHandler {

    public static void main(String[] args)throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("servlet.xml");
        context.start();
        IBrandService demoService = (IBrandService)context.getBean("brandService"); // 获取远程服务代理
        List<Brand> hello = demoService.find(null); // 执行远程方法
        System.out.println(hello); // 显示调用结果
    }
}
