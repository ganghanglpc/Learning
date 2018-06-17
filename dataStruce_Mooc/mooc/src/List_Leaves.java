import java.util.Scanner;

public class List_Leaves {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());
        Tree tree = new Tree(N);
        String sleft;
        String sright;

        /* Read */
       for(int i = 0;i < N;i++){
            sleft = in.next();
            if(!sleft.equals("-")){
                tree.arr[i].left = Integer.parseInt(sleft);
            }else {
                tree.arr[i].left = -1;
            }
            sright = in.next();
            if(!sright.equals("-")){
                tree.arr[i].right = Integer.parseInt(sright);
            }else {
                tree.arr[i].right = -1;
            }
            tree.arr[i].index = i;
        }
        /* to find parent node */
        int parent = 0;
        StringBuffer sb1 = new StringBuffer();
        for(int j = 0;j < N;j++){
            sb1.append(j+"");
        }
        StringBuffer sb2 = new StringBuffer();
        for(Node node : tree.arr){
            if (node.left != -1) sb2.append(node.left);
            if (node.right != -1) sb2.append(node.right);
        }
        System.out.print(parent);
       /*
        Queque queque = new Queque(3);
        queque.add(new Node(1,1,0));
        queque.add(new Node(2,2,3));
        queque.add(new Node(1,3,2));
        queque.delete();
        System.out.print(queque.queque[0].index);*/

      /* Queque queque = new Queque(N);
       queque.add(tree.arr[parent]);
       int[] pos = new int[N];
       int i = 0;
       while (!queque.isEmpty()){
           int left = queque.delete().left;
           int right = queque.delete().right;
           if(left == -1 && right == -1){
               pos[i] = queque.delete().index;
               i++;
               break;
           } else {
               if (left != -1)
                   queque.add(tree.arr[left]);
               if (right != -1)
                   queque.add(tree.arr[right]);
           }
       }

       for (int j = 0;j < pos.length;j++){
           System.out.print(pos[j]);
           if(j<pos.length-1) System.out.print(" ");
       }
       */
    }

}

class Node{
    int left=-1;
    int right=-1;
    int index=-1;

    public Node(){
        this.left = -1;
        this.right = -1;
        this.index = -1;
    }

    public Node(int left,int right,int index){
        this.left = left;
        this.right = right;
        this.index = index;
    }
}

class Tree{
    int n = 10;
    Node[] arr;
    public Tree(int n){
        this.n = n;
        this.arr = new Node[n];
        for(int i = 0;i < n; i++){
            this.arr[i] = new Node();
        }
    }
}

class Queque{
    int n;
    int head;
    Node[] queque;
    public Queque(int n){
        this.n = n;
        this.head = -1;
        this.queque = new Node[n];
    }

    public boolean isEmpty(){
        return this.head == -1;
    }
    public void add(Node node){

        for(int i = this.head;i>=0;i--){
            queque[i + 1] = queque[i];
        }
        queque[0] = node;
        this.head++;
    }

    public Node delete(){
        Node temp = queque[this.head];
        queque[this.head] = null;
        this.head--;
        return temp;
    }

}