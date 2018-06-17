import java.util.Scanner;

/**
 * Josephus问题，我用了循环单链表解决
 * 用堆栈解决（链表表示）或许也是一种思路，未经实验。
 * 用动态数组实现可以吗？ 当清空时，置0，数组的遍历较快。
 */
public class Josephus {

    public static  void main(String ags[]){
        Scanner in = new Scanner(System.in);

        int N = 0;
        N = Integer.parseInt(in.next());
        int M = 0;
        M = Integer.parseInt(in.next());
        //默认第一个结点存在，且尾指针为空
        LNode node = new LNode(1,null);

        Josephus josephus = new Josephus();

        //插入节点
        for (int i = 2;i <= N;i ++){
           josephus.Insert(node,i);
        }

        LNode temp = new LNode();
        while (node != null){
            for (int j = 0; j < M;j ++){
                node = node.getNext();
                if(node == null) break;
            }
            if (node == null) break;
            else {
                temp = node;
                Josephus.Delete(node);
                node = temp.getNext();
                //如果结点的尾指针指向自己，说明此时只剩一个结点。
                if (node.getNext() == node) break;
            }
        }

       // Josephus.Delete(node.getNext());
        System.out.println(node.getNumber());
    }

    /**
     * 插入新节点，并且与头结点相连接。
     * @param node
     * @param number
     */
    public void Insert(LNode node,int number){
        /*创建新节点*/
        LNode newNode = new LNode(number,null);
        LNode head = node;
        while (node.getNumber() != number-1){
            node = node.getNext();
        }
        /*新节点与头结点相连*/
        node.setNext(newNode);
        newNode.setNext(head);

    }

    /**
     * 根据 M 删除节点
     * @param node
     */
    public static void Delete(LNode node){

        int num = node.getNumber();

        LNode preNode = Josephus.findPrevios(node,num);

        preNode.setNext(node.getNext());

    }

    /**
     * 找到想删除节点的前一个节点，便于删除。
     * @param node
     * @param num
     * @return
     */
    public static LNode findPrevios(LNode node,int num){

        LNode preNode = node;

        while (preNode.getNext() !=null && preNode.getNext().getNumber() != num){
            preNode = preNode.getNext();
        }

        return preNode;
    }


}

class LNode{
    private int number;
    private LNode next;

    public LNode(){
        super();
    }

    public LNode(int number,LNode next){
        super();
        this.number = number;
        this.next = next;
    }

    public LNode getNext() {
        return next;
    }

    public void setNext(LNode next) {
        this.next = next;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
