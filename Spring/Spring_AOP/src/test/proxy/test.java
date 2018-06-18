package test.proxy;

import proxy.ForumService;
import proxy.ForumServiceImpl;

public class test {

    public static void main(String args[]){
        ForumService forumService = new ForumServiceImpl();
        forumService.removeTopic(20);
        forumService.removeForum(500);
    }
}
