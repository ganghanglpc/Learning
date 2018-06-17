import java.util.Scanner;

/**
 * 解题思路：
 * 1 任意搜索树的中序输出是一个递增数列。
 * 2 CBT的父结点与左右子节点下标间的关系。
 */
public class CBT0406 {

    private static int j = 0;
    private static int[] b;

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int num = Integer.parseInt(in.next());
        int[] arr = new int[num + 1];
        for(int i = 1; i <= num; i ++){
            arr[i] = Integer.parseInt(in.next());
        }
        sort(arr);

        b = new int[num];

        find(1,arr,num);
        for (int i = 1;i <= arr.length; i ++){
            System.out.println(b);
        }
    }

    public static void sort(int[] arr){
        for(int i = 1;i < arr.length - 1 ; i ++){
            int k = i;
            for(int j = i + 1; j < arr.length ; j ++){
                if(arr[k] > arr[j]) k = j;
            }
            int temp = arr[k];
            arr[k] = arr[i];
            arr[i] = temp;
        }
    }

    public static void find(int root,int[] arr,int num){
        if(root <= num){
            find(root * 2,arr,num);
            b[root] = arr[j++];
            find(2*root + 1,arr,num);
        }
    }
}
