import java.util.Scanner;

/**
 * 链表反转
 */
public class ReversingLinkedList {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        String HeadAddress = in.next();
        int num = Integer.parseInt(in.next());
        int K = Integer.parseInt(in.next());

        RNode[] arr = new RNode[num];
        for(int i = 0; i < num; i ++){
            RNode rNode = read();
            arr[i] = rNode;
        }

        RNode rNode = new RNode();
        RNode Next = new RNode();
        rNode.Next = Next;
        Next.address = HeadAddress;
        int count = 1;
        while (count < num){
            count++;
            Next = insert(arr,Next);
        }

        RNode reRNode = revearse(K,rNode,num);
        RNode rNode1 = reRNode.Next;
        RNode rNode2 = reRNode.Next;
        for (int i = 0; i < num; i++){
            if(rNode1.Next != null)
            rNode1.next = rNode1.Next.address;
            else {
                rNode1.next = "-1";
            }
            rNode1 = rNode1.Next;
        }

        for (int i = 0;i < num; i ++){
            System.out.print(Integer.parseInt(rNode2.address) + " ");
            System.out.print(rNode2.data + " ");

            System.out.println(rNode2.next);
            rNode2 = rNode2.Next;
        }
    }

    /* as u can see,use the function to read the input data*/
    public static RNode read(){
        Scanner in = new Scanner(System.in);
        String address = in.next();
        int data = Integer.parseInt(in.next());
        String next = in.next();
        RNode rNode = new RNode();
        rNode.address = address;
        rNode.data = data;
        rNode.next = next;
        rNode.Next = null;
        return rNode;
    }
    /* Initialization */
    public static RNode insert(RNode[] arr,RNode rNode){
        /* 如果是头结点 */
        RNode temp = rNode;
        if(temp.Next == null){
            for(int i = 0;i<arr.length;i++){
                if(arr[i].address.equals(temp.address)){
                    temp.data = arr[i].data;
                    temp.next = arr[i].next;
                    for(int j = 0; j < arr.length;j ++){
                        if(arr[j].address.equals(temp.next)){
                            temp.Next = arr[j];
                        }
                    }
                }
            }
        }else {
            while (temp.Next != null)
                temp = temp.Next;
            for(int i = 0;i<arr.length;i++){
                if(arr[i].address.equals(temp.address)){
                    temp.data = arr[i].data;
                    temp.next = arr[i].next;
                    for(int j = 0; j < arr.length;j ++){
                        if(arr[j].address.equals(temp.next)){
                            temp.Next = arr[j];
                        }
                    }
                }
            }
        }
        return rNode;
    }

    public static RNode revearse(int K,RNode rNode,int num){
        RNode now = rNode.Next;
        RNode next = now.Next;
        RNode last;
        if(next != null) {
            last = next.Next;
        }else {
            last = null;
        }
        RNode temp = null;
        RNode head = null;
        int count = 1;
        /* 默认操作都正常，没有异常输入数据，如K大于N*/
        int times = num/K;
        if(times == 1) {
            while (count < K) {
                next.Next = now;
                now = next;
                next = last;
                last = last.Next;
                count++;
            }
            rNode.Next.Next = next;
            rNode.Next = now;
        }else {
            while (count < times * K) {
                next.Next = now;
                now = next;
                if(last != null) {
                    next = last;
                    last = last.Next;
                }else {
                    next = null;
                }
                count++;
                if(count / K == 1 && count%K == 0){
                    temp = now;
                    head = next;
                }else if(count%K == 0){
                    head.Next = next;
                }
            }
            rNode.Next.Next = now;
            rNode.Next = temp;
        }
        return rNode;
    }
}

class RNode{
    int data;
    String address;
    String next;
    RNode Next;
}
