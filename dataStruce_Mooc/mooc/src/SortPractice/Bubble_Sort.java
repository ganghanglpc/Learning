package SortPractice;

import java.util.Scanner;

public class Bubble_Sort {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());
        int[] arr = new int[N];

        for(int i = 0;i < N; i ++){
            arr[i] = Integer.parseInt(in.next());
        }

        Sort(arr,N);

        for(int i = 0;i < N;i ++){
            if(i < N-1)
                System.out.print(arr[i] + " ");
            else
                System.out.print(arr[i]);
        }
    }

    public static void Sort(int[] arr,int N){
        int k = 0;
        int temp = 0;
        for(int i = 0; i < N - 1; i ++){
            k = i;
            for(int j = i + 1; j < N;j ++){
                if(arr[k] > arr[j]) k = j;
            }
            temp = arr[i];
            arr[i] = arr[k];
            arr[k] = temp;
        }
    }
}
