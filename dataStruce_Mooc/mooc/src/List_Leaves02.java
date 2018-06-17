import java.util.Scanner;

public class List_Leaves02 {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        int num = Integer.parseInt(in.next());
        String sleft;
        String sright;
        LfNode[] arr = new LfNode[num];
        /* Initialize */
        for(int i = 0;i < num; i++){
            arr[i] = new LfNode();
        }

        for(int i = 0;i < num; i++){
            sleft = in.next();
            if(!sleft.equals("-")){
                arr[i].left = Integer.parseInt(sleft);
                arr[arr[i].left].parent = i;
            }
            sright = in.next();
            if(!sright.equals("-")){
                arr[i].right = Integer.parseInt(sright);
                arr[arr[i].right].parent = i;
            }
        }
        /* Test1 for Initialize */
       /* for(LfNode node : arr){
        System.out.println(node);}
        */
       int root = -1;
       for(int i = 0; i<num; i++){
           if(arr[i].parent == -1 ){
               root = i;
               break;
           }
       }
       /* Test for root */
       //System.out.print(root);
        int[] queue = new int[num];
        int rear = 0;
        int head = 0;
        int flag = 0;
        queue[rear++] = root;
        while(head < rear){
            int temp = queue[head];
            head++;
             if(arr[temp].left == -1 && arr[temp].right == -1){
                 if(flag == 1){
                     System.out.print(" ");
                 }
                 System.out.print(temp);
                 flag = 1;
             }
             if(arr[temp].left != -1){
                 queue[rear++] = arr[temp].left;
             }
            if(arr[temp].right != -1){
                queue[rear++] = arr[temp].right;
            }

        }


    }

}




class LfNode{
    int left;
    int right;
    int parent;

    public LfNode(){
        this.left = -1;
        this.right = -1;
        this.parent = -1;

    }

    @Override
    public String toString() {
        return "LfNode{" +
                "left=" + left +
                ", right=" + right +
                ", parent=" + parent +
                '}';
    }
}
