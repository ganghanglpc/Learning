import java.io.*;

/**
 * 通过管道进行线程间的通信：字符流
 */
public class Run {
    public static void main(String args[]){
        try{
            WriteData writeData = new WriteData();
            ReadData readData = new ReadData();
            PipedReader in = new PipedReader();
            PipedWriter out = new PipedWriter();

            out.connect(in); //连接两个管道

            ThreadRead read = new ThreadRead(readData,in);
            read.start();

            Thread.sleep(2000);

            ThreadWrite write = new ThreadWrite(writeData,out);
            write.start();
        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
