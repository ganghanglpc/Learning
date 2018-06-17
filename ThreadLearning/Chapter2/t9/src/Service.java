public class Service {
    public MyOneList addServiceMethod(MyOneList list,String data){
        try{
            synchronized (list) {   //锁住
                if (list.getSize() < 1) {
                    Thread.sleep(2000); //模拟从远程花费两秒取数据
                    list.add(data);
                }
            }
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        return list;
    }
}
