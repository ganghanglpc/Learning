package resource;

import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.io.InputStream;

/**
 * 只有反射还不行，Spring还定义了对资源（如配置文件）的访问接口 Resource
 * 在获取资源后，用户就可以根据获得的资源去访问文件的数据和其他的信息。
 * 在Web应用中，还可以通过ServletContextResource来获取 相对于Web应用根目录的资源
 */
public class FileSourceExample {
    public static void main(String args[]){
        try{
            String filePath = "C:/Users/user/IdeaProjects/Spring_IoC/src/resource/test.java";

            //以系统文件路径方式加载文件
            Resource res1 = new FileSystemResource(filePath);
            //以相对路径加载文件
            Resource res2 = new ClassPathResource("resource/test.txt");

            InputStream ins1 = res1.getInputStream();
            InputStream ins2 = res2.getInputStream();
            System.out.println("res1:" + res1.getFilename());
            System.out.println("res2:" + res2.getFilename());
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
