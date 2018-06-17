import java.io.PipedInputStream;
import java.io.PipedReader;

public class ThreadRead extends Thread {
    private ReadData readData;
    private PipedReader in;

    public ThreadRead(ReadData readData, PipedReader in) {
        this.readData = readData;
        this.in = in;
    }

    @Override
    public void run() {
        super.run();
        readData.readMethod(in);
    }
}
