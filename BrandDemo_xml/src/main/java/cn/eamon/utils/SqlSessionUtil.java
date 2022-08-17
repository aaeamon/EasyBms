package cn.eamon.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class SqlSessionUtil {


    private static SqlSessionFactory sessionFactory = null;

    /*
        抽取到静态代码块，主要是为了确保这个工厂以及读取配置文件的工作只会执行一次！
     */
    static {
        try {
            InputStream is = Resources.getResourceAsStream("SqlMapConfig.xml");
            SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
            sessionFactory = builder.build(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * 暴露一个方法，只要来调用这个方法，就可以获取session对象
     * @return
     */
    public static SqlSession getSession(){
        return sessionFactory.openSession();
    }
}
