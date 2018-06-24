package test.annotation;

import annotation.ForumService;
import annotation.NeedTest;

import java.lang.reflect.Method;

/**
 * JDK5.0新增了对注解信息的反射机制
 * 前提是 注解类型时Retention.Runtime类型 （运行期间可以反射）
 */
public class TestTool {
    public static void main(String args[]){
        Class clazz = ForumService.class;
        Method[] methods = clazz.getMethods();
        System.out.println(methods.length);
        for(Method method: methods){
            NeedTest nt = method.getAnnotation(NeedTest.class);
            if(nt!=null){
                if(nt.value()){
                    System.out.println(method.getName() + "()需要测试");
                }else {
                    System.out.println(method.getName() + "()不需要测试");
                }
            }
        }
    }
}
