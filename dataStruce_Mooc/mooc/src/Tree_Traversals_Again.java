import java.util.Scanner;

public class Tree_Traversals_Again {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int capacity = Integer.parseInt(in.next());
        StackNode stackNode = new StackNode(capacity);
        /* Initialize */
        int count = 1;
        int[] arr = new int[capacity];
        int position = 0; //this position is arr's
        /* 假设操作都合法...= = */
        while(count <= 2 * capacity){
            String operator = in.next();
            if(operator.equals("Push")){
                int value = Integer.parseInt(in.next());
                Push(stackNode,value);
            }else{
                if(operator.equals("Pop")){
                    arr[position] = Pop(stackNode);
                    position++;
                }
            }
            count ++;
        }
        position--;
        Invide(0,position,arr,0);

        /* test for push */

        /*for(int i = 0;i < 10; i++){
            Push(stackNode,i);
        }
        for(int i = 0; i<stackNode.data.length;i++){
            System.out.println(stackNode.data[i]);
        }*/

        /* test for pop */
        /*
        for(int i = 0;i < 10; i++){
            Push(stackNode,i);
        }

        for(int i = 0; i < 10;i++){
            System.out.println(Pop(stackNode));
        }*/


    }

    /**
     * Push操作，为了简化代码，这里就不判断堆栈是否已满的情况。实际上这样写是不严谨的。
     * @param stackNode
     * @param element
     */
    public static void Push(StackNode stackNode,int element){
        /* 未判断堆栈是否已满 */
        stackNode.position++;
        stackNode.data[stackNode.position] = element;
    }

    /**
     * 同样，未做判断堆栈是否已空的情况。
     * @param stackNode
     * @return
     */
    public static int Pop(StackNode stackNode){
        return stackNode.data[stackNode.position--];
    }

    public static void Invide(int left,int right,int[] arr,int flag){
        int num = right - left + 1;
        int sright = 0;
        int temp = 1;
        if(left == right){
            //需要做一步判断是否为最后一个元素（即根元素）输出后面无空格。
            if(arr.length == 1){
                System.out.print(arr[left]);
            }else {
                System.out.print(arr[left] + " ");
            }
        }else{
            int h = (int)(Math.log(num)/Math.log(2)) + 1;
            int h_sum = num - ((int)Math.pow(2,h-1) - 1);
            int left_h_sum = (int)Math.pow(2,h-2);
            if((h_sum - left_h_sum) >= 0){
                 sright = left + ((int)Math.pow(2,h-1) - 1) - 1;
            }else{
                 sright = left + ((int)Math.pow(2,h-2) - 1) - 1 + left_h_sum;
            }
            int center = sright + 1;
            Invide(left,sright,arr,temp);
            if(center == right){
                Invide(center,right,arr,temp);
            }else {
                Invide(center+1,right,arr,temp);
                if( flag == 0){
                    System.out.print(arr[center]);
                }else {
                    System.out.print(arr[center] + " ");
                }
            }
        }
    }

}

/**
 * data struct defined by coder to modify the "Stack".
 */
class StackNode{
    int data[];
    int position;

    public StackNode(int capacity){
        this.data = new int[capacity];
        this.position = -1;
    }
}
