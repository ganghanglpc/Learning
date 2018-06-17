import java.util.Scanner;

public class LinearStruct02_2 {

    public static void main(String args[]){
        LsNode node1 = Read();
        LsNode node2 = Read();
        LsNode m1node = new LsNode();
        LsNode m2node = new LsNode();
        LsNode temp1 = node1;
        LsNode temp2 = node2;
        while(temp1.next != null){
            m1node = insert(m1node,temp1.next.cof,temp1.next.exp);
            temp1 = temp1.next;
        }
        while(temp2.next != null){
            m2node = insert(m2node,temp2.next.cof,temp2.next.exp);
            temp2 = temp2.next;
        }
        LsNode sum = sum(node1,node2);
        LsNode mul = Multi(m1node,m2node);
        if(node1.next == null && node2.next == null){
            System.out.print(0 + " " + 0);
        }else{
            Print(mul);
        }
        System.out.printf("\n");
        Print(sum);


    }
    /*
    求积
     */
    public static LsNode Multi(LsNode L1,LsNode L2){
        int cof,exp;
        LsNode L,head,temp,temp1,temp2;
        L = new LsNode();
        L.next = null;
        temp1 = L1;
        temp2 = L2;
        head = L2; //记录L2头结点
        //主程序上一步已确定两者不能同时为空
        if(temp1.next == null){
            L.next = temp2.next;
            return L;
        }else if(temp2.next == null){
            L.next = temp1.next;
            return L;
        }
        while(temp1.next!=null){
            temp = new LsNode();
            temp.next = null;
            while(temp2.next != null){
                cof = temp1.next.cof *temp2.next.cof;
                exp = temp1.next.exp + temp2.next.exp;
                temp2 = temp2.next;
                temp = insert(temp,cof,exp);
            }
            temp2 = head;//每循环L2链表一次，L2都会指向最后一个结点，所以在这里令他指回头结点。
            temp1 = temp1.next;
            //循环完成 新旧链表相加.
            L = sum(L,temp);
        }
        return L;
    }
    /*
    打印多项式
     */
    public static void Print(LsNode L){
        int flag = 0;
        while(L.next != null){
            if(flag == 0){
                System.out.printf("%d %d",L.next.cof,L.next.exp);
                flag = 1;
                L = L.next;
            }else{
            System.out.printf(" %d %d",L.next.cof,L.next.exp);
            L = L.next;}
        }
    }
    /*
    插入
     */
    public static LsNode insert(LsNode L,int c,int e){
        LsNode node = new LsNode();
        node.cof = c;
        node.exp = e;
        node.next = null;
        LsNode head = L;
        while (L.next != null){
            L = L.next;
        }
        L.next = node;
        return head;
    }
    /*
    读数，头结点为空
     */
    public static LsNode Read(){
        int num,cof,exp,temp;
        LsNode lsNode = new LsNode();
        lsNode.next = null;
        Scanner in = new Scanner(System.in);
        num = Integer.parseInt(in.next());
        for(int i = 0;i<num;i++){
            cof = Integer.parseInt(in.next());
            exp = Integer.parseInt(in.next());
            lsNode = insert(lsNode,cof,exp);
        }
        return lsNode;
    }
    /*
    求和
     */

    public static LsNode sum(LsNode L1,LsNode L2){
        LsNode L,temp,head,temp1,temp2;
        temp1 = L1.next;
        temp2 = L2.next;
        L = new LsNode();
        L.next = null;
        head = L;
        while(temp1!=null&&temp2!=null){
            if( temp1.exp > temp2.exp){
                L.next = temp1;
                L = L.next;
                temp1 = temp1.next;
            }else if( temp1.exp < temp2.exp){
                L.next = temp2;
                L = L.next;
                temp2 = temp2.next;
            }else{
                temp = new LsNode();
                temp.cof = temp1.cof + temp2.cof;
                temp.exp = temp1.exp;
                L.next = temp;
                L = L.next;
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
        }
        L.next = temp1!=null?temp1:temp2;

        return head;
    }
}

class LsNode{
    int cof;
    int exp;
    LsNode next;

    @Override
    public String toString() {
        return "LsNode{" +
                "cof=" + cof +
                ", exp=" + exp +
                ", next=" + next +
                '}';
    }
}
