package SortPractice;

import java.util.Scanner;

/**
 * 希尔排序
 * 顺便练习插入排序
 */
public class Shell_Sort{

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(in.next());
        }

        Sort(arr,N);

        for(int i = 0;i < N;i ++){
            if(i < N - 1)
                System.out.print(arr[i] + " ");
            else
                System.out.print(arr[i]);
        }
    }
    /******************* Sedgewick ********************/
    public static void Sort(int[] arr,int N){
        int Sedgewick[] = {929,505,209,109,41,19,5,1,0};
        int i = 0,j = 0;
        int temp = 0;
        /*  增量不能大于待排数组长度 */
        for(i = 0;Sedgewick[i] > N; i ++);

        for(int D = Sedgewick[i]; D > 0; D = Sedgewick[i++]){
            for(int P = D; P < N; P ++){
                temp = arr[P];   //取出未排序列中的第一个数
                for(j = P;j >= D && arr[j - D] > temp; j -= D){
                    arr[j] = arr[j - D];   //比较大小，依次右移
                }
                arr[j] = temp;
            }
        }
    }

}
