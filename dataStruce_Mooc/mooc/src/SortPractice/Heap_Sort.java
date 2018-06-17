package SortPractice;

import java.util.Scanner;

/**
 * 堆排序
 * 利用最大堆来进行排序
 */
public class Heap_Sort {

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
    /*  经过一定调整的下滤过程，如果根节点值比较小，则一直下滤，前提是它的左子树或者右子树已经调整为最大堆 */
    public static void PercDown(int[] A,int p,int N){
        int X = A[p];
        int child = 0;
        int parent;
        for(parent = p; (parent * 2 + 1 ) < N ; parent = child ){
            child = 2 * parent + 1;
            /* 找到子节点中较大者 */
            if(child != N -1 && A[child + 1] > A[child])
                child ++;
            /* 如果找到了合适位置 */
            if(X >= A[child])
                break;
            else
                A[parent] = A[child];
        }
        A[parent] = X;
    }
    /* 利用不断下滤，建造最大堆*/
    public static void BuildMaxHeap(int[] A,int N){
        for(int i = N/2 - 1; i >= 0; i--){
            PercDown(A,i,N);
        }
    }

    public static void Sort(int[] arr,int N){
        BuildMaxHeap(arr,N);
        int temp = 0;
        /* “删除”堆顶元素，然后重新下滤新的堆顶元素，重新“创建了一个最大堆”*/
        for (int i = N -1;i > 0;i --){
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            PercDown(arr,0,i);
        }
    }
}
