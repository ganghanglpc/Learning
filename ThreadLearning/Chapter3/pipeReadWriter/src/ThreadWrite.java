import java.io.PipedOutputStream;
import java.io.PipedWriter;

public class ThreadWrite extends Thread {
    private WriteData writeData;
    private PipedWriter out;

    public ThreadWrite(WriteData writeData,PipedWriter out) {
        this.writeData = writeData;
        this.out = out;
    }

    @Override
    public void run() {
        super.run();
        writeData.writeMethod(out);
    }
}
