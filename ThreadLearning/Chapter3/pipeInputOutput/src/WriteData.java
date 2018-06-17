import java.io.IOException;
import java.io.PipedOutputStream;

public class WriteData {

    public void writeMethod(PipedOutputStream out){
        try{
            System.out.println("write :");
            for(int i = 0; i < 300; i ++){
                String outData = "" + ( i + 1 );
                out.write(outData.getBytes());   //写入字节流
                System.out.print(outData);
            }
            System.out.println();
            out.close(); //管道使用完之后一定要关闭！！！
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
