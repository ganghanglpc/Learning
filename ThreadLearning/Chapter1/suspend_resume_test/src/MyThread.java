public class MyThread extends Thread {
    private int i = 0;

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        super.run();
        while (true){
            i++;
        }
    }
}
