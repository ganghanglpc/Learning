import java.io.IOException;
import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class WriteData {

    public void writeMethod(PipedWriter out){
        try{
            System.out.println("write :");
            for(int i = 0; i < 300; i ++){
                String outData = "" + ( i + 1 );
                out.write(outData);   //写入字符流
                System.out.print(outData);
            }
            System.out.println();
            out.close(); //管道使用完之后一定要关闭！！！
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
