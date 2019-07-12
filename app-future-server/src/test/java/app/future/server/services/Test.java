package app.future.server.services;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args)throws Exception{
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationProvider.xml");
        context.start();
        System.out.println("provider start ...");
        System.in.read(); // 按任意键退出
    }
}
