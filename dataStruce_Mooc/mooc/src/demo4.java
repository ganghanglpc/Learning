import java.util.Scanner;

/**
 * 寻找 不大于 N 的数以下  一共有几对素数对。
 */
public class demo4 {

    public static void main(String args[]){
        int count = 0;
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());

        int num = 1;
        int nextNum = 3;
        /**
         * 笨办法：遍历。
         */

        while (num < N){

            if (nextNum > N) break;
            /**
             * 都是素数
             */
            if (demo4.isSushu(num) && demo4.isSushu(nextNum)) {
                count ++;
                num = nextNum + 2;
                nextNum = num + 2;
                continue;
            }
            /**
             * 前者是素数，后者不是素数。
             */
            if (!demo4.isSushu(num) && demo4.isSushu(nextNum)){
                num = nextNum;
                nextNum = num + 2;
                continue;
            }
            /**
             * 前者不是素数，后者是素数。
             */
            if (demo4.isSushu(num) && !demo4.isSushu(nextNum)){
                nextNum = nextNum + 2;
                continue;
            }
            /**
             * 前后都不是素数。
             */
            if(!demo4.isSushu(num) && !demo4.isSushu(nextNum)){
                num = nextNum;
                nextNum = num + 2;
            }
        }
        System.out.println(count);
    }

    public static boolean isSushu(int num){

        boolean isSushu = true;
        for (int i = 1;i <= Math.sqrt(num);i = i +2){
            if (num % i == 0 && i !=1 ){
                isSushu = false;
                break;
            }
        }
        return isSushu;
    }
}
