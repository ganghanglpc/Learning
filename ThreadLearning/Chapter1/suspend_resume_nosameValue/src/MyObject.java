public class MyObject {
    private String username = "1";
    private String password = "11";
    public void setVaule(String u,String p){
        this.username = u;
        if(Thread.currentThread().getName().equals("a")){
            System.out.println("停止a线程!");
            Thread.currentThread().suspend();
        }
        this.password = p;
    }
    public void print(){
        System.out.println(username + " " + password);
    }
}
