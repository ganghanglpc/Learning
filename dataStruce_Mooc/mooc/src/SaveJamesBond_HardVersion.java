import java.util.Scanner;

public class SaveJamesBond_HardVersion {
    private static int D;
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int N = Integer.parseInt(in.next());
        D = Integer.parseInt(in.next());

        CNode[] coordinate = new CNode[N];
        int[] path = new int[N];
        int[] distance = new int[N];
        int[] newdistance = new int[N];
        int[] newpath = new int[N];

        for(int i = 0;i < N;i ++){
            coordinate[i] = new CNode();
            path[i] = -1;
            coordinate[i].x = Integer.parseInt(in.next());
            coordinate[i].y = Integer.parseInt(in.next());
            coordinate[i].pos = i;
        }

        CNode center = new CNode();
        center.x = 0;
        center.y = 0;
        int length = N;
        int count = 0;
        int index = 0;
        if(isInCircle(center)){
            System.out.println(1);
        }else {
            for (int i = 0; i < N; i++) {

                if (isInJumpdis(center, coordinate[i])) {
                    for (int j = 0; j < N; j++) {
                        distance[j] = 0;
                    }
                    distance[i] = 1;
                    path = unweighted(coordinate, path, distance, coordinate[i]);

                    int maxValue = dealDis(distance);
                    int road = 0;
                    for (int k = 0; k < N; k++) {
                        if (distance[k] == maxValue && isInCircle(coordinate[k])) {
                            road = k;
                            count = 0;
                            while (road != -1) {
                                road = path[road];
                                count++;
                            }
                            break;
                        }
                    }
                    if (count < length && count != 0) {
                        length = count;
                        newdistance = distance;
                        for (int k = 0; k < N; k++) {
                            newpath[k] = path[k];
                        }
                        //index = unweighted(coordinate,path,distance,coordinate[i]).index;
                    }
                    for (int j = 0; j < N; j++) {
                        path[j] = -1;
                    }
                    count = 0;
                }
            }

            int maxValue = dealDis(newdistance);
            StaNode staNode = new StaNode(N);
            int road = 0;
            count = 0;
            for (int i = 0; i < N; i++) {
                if (newdistance[i] == maxValue && isInCircle(coordinate[i])) {
                    road = i;

                    while (road != -1) {
                        staNode.push(road);
                        road = newpath[road];
                        count++;
                    }
                    break;
                }
            }
            int flag = 0;

            if (count != 0) {
                System.out.println(count + 1);
                while (!staNode.isEmptey()) {
                    if (flag == 0) {
                        flag = staNode.pop() + 1;
                    } else {
                        int pos = staNode.pop();
                        System.out.println(coordinate[pos].x + " " + coordinate[pos].y);
                    }
                }
            } else {
                System.out.println(0);
            }
        }


    }

    public static int dealDis(int[] arr){
        int max = 0;
        for(int i = 0;i < arr.length; i ++){
            if(arr[i] > max) max = arr[i];
        }
        return max;
    }

    public static int[] unweighted(CNode[] coordinate,int[] path,int[] distance,CNode start){
        //CNode start = coordinate[0];
       // distance[0] = 0;
        boolean flag = false;
        CQueue cQueue = new CQueue(coordinate.length);
        cQueue.Enqueue(start);
        StaNode staNode = new StaNode(coordinate.length);
        while (!cQueue.isEmpty()){
            CNode cNode = cQueue.Dequeue();
            if(isInCircle(cNode)){
                return path;
            }
            for(int i = 0;i < coordinate.length;i ++){
                if(distance[i] == 0 && isInJumpdis(cNode,coordinate[i]) && cNode!=coordinate[i]){
                    distance[i] = distance[cNode.pos] + 1;
                    path[i] = cNode.pos;
                   // staNode.push(cNode.pos);
                    cQueue.Enqueue(coordinate[i]);
                    if(isInCircle(coordinate[i])){
                        flag = true;
                        break;
                    }
                }
            }
            if(flag){
                return path;
            }
        }
        for(int i = 0;i < coordinate.length;i ++){
            path[i] = -1;
        }

        return path;
    }

    public static boolean isInJumpdis(CNode cNode1,CNode cNode2){
        if((cNode1.x-cNode2.x)*(cNode1.x-cNode2.x) + (cNode1.y-cNode2.y)*(cNode1.y-cNode2.y) <= D*D ){
            return true;
        }else
            return false;
    }

    public static boolean isInCircle(CNode cNode){
        int x = cNode.x;
        int y = cNode.y;
        if((y-50)*(y-50) <= D*D || (50-x)*(50-x) <= D*D || (x+49)*(x+49) <= D*D || (y+49)*(y+49) <= D*D){
            return true;
        }else
            return false;
    }

    public static void push(int[] arr,int x,int index){
        arr[index] = x;
    }

}



/*假设队列操作都合法，未进行校验*/
class CQueue{
    int head;
    int rear;
    int size;
    CNode[] cNodes;

    public CQueue(int size){
        this.size = size;
        this. head = 0;
        this.rear = 0;
        this.cNodes = new CNode[size];
    }

    public void Enqueue(CNode cNode){
        cNodes[rear] = cNode;
        rear++;
    }

    public CNode Dequeue(){
        CNode cNode = cNodes[head];
        cNodes[head] = null;
        head++;
        return cNode;
    }

    public boolean isEmpty(){
        return head == rear?true:false;
    }
}
/*假设堆栈操作都合法，未进行校验*/
class StaNode{
    int index;
    int[] arr;

    public StaNode(int size){
        this.index = 0;
        this.arr = new int[size];
    }

    public void push(int ele){
        arr[index] = ele;
        index ++;
    }

    public int pop(){
        int temp = this.index;
        index --;
        return arr[temp];
    }

    public boolean isEmptey(){
        if(index == -1)
            return true;
        else
            return false;
    }
}


