import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.io.PipedReader;

public class ReadData {

    public void readMethod(PipedReader input){
        try{
            System.out.println("read :");
            char[] byteArrays = new char[20];
            int readLength = input.read(byteArrays); //读入字节流返回的是一个长度
            while (readLength != -1){
                String newData = new String(byteArrays,0,readLength);
                System.out.print(newData);
                readLength = input.read(byteArrays);
            }
            System.out.println();
            input.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
