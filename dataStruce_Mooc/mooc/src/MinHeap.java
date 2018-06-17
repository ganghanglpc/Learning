import java.util.Scanner;

/**
 * 最小堆，不包括删除操作（简化了许多）
 */
public class MinHeap {

    public static void main(String args[]){

        Scanner in = new Scanner(System.in);
        int num = Integer.parseInt(in.next());
        int path_num = Integer.parseInt(in.next());
        HNode hNode = new HNode(num+1);

        hNode.element[0] = -10001;
        for (int i = 0;i < num; i ++){
            int data = Integer.parseInt(in.next());
            insert(hNode,data,i);
        }

        for (int j = 0;j < path_num;j ++){
            int beginIndex = Integer.parseInt(in.next());
            _print(beginIndex,hNode.element);
            if(j != path_num -1){
                System.out.println();
            }
        }
    }

    /**
     * 插入操作，不用写删除噢= =
     * @param h
     * @param data
     * @param size
     * @return
     */
    public static HNode insert(HNode h,int data,int size){
        /* 默认插入的数个数始终不超过数组长度 */

        h.element[++ size] = data;
        int i = size;
        for( ; data < h.element[i/2]; i = i/2 ){
            h.element[i] = h.element[i/2];
        }
        h.element[i] = data;
        return h;
    }

    public static void _print(int beginIndex,int[] arr){
        int height = 1;
        int index = beginIndex;
        while(Math.pow(2,height) -1 < beginIndex){
             height ++;
        }
        for (int i = 0;i < height; i++){
            if(i != height-1){
                System.out.print(arr[index] + " ");
            }else {
                System.out.print(arr[index]);
            }
            index = index/2;
        }
    }
}

class HNode{
    int size;
    int[] element;
    public HNode(int size){
        this.element = new int[size];
    }
}
