package annotation;

public class ForumService {
    @NeedTest(true)
    public void deleteForum(int forumId){
        System.out.println("删除论坛模块 ：" + forumId);
    }
    @NeedTest(false)
    public void deleteTopic(int postId){
        System.out.println("删除论坛主题 ：" + postId);
    }
}
