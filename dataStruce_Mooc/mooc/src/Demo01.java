import java.util.Scanner;

public class Demo01 {

    public static void main(String agrs[]){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String cr = in.next();
        //System.out.print(num + cr);

        if (num == 0){
            System.out.print("0");
            return;
        }

        int i = 0;
        int sum = 1;
        int count = 0;

        do {
            if (i == 0) {
                i++;
                sum = 1;
            }else {
                i = i + 2;
                sum = sum + 2 * i;
                if (sum > num){
                    sum = sum - 2*i;
                    i = i -2;
                    break;
                }
            }
            count ++;
        }while (sum < num);
        //System.out.print(count);

        for (int j = 0; j < count - 1; j ++ ){
            for (int k = 0;k < j;k ++){
                  System.out.print(" ");
            }
            for (int k = 0; k < i - 2*j; k ++){
                System.out.print(cr);
            }
            for (int k = 0;k < j;k ++) {
                System.out.print(" ");
            }
            System.out.println();
        }


        for (int m = 0;m < count - 1;m ++){
            System.out.print(" ");
        }
        System.out.print(cr);
        for (int m = 0;m < count - 1;m ++){
            System.out.print(" ");
        }
        System.out.println();



        for (int j = count - 1; j > 0; j -- ){
            for (int k = j - 1;k > 0;k --){
                System.out.print(" ");
            }
            for (int k = 0; k <= i - 2*j + 1; k ++){
                System.out.print(cr);
            }
            for (int k = j - 1;k > 0;k --) {
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println(num - sum );
    }
}
