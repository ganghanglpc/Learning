import java.util.Scanner;

/**
 * 判断树是否同构
 * @author lpc.
 * @time 2018.04.07
 */
public class IfSameStruct {

    public static void main(String args[]){
        TreeNode[] arr1 = read();
        TreeNode[] arr2 = read();
        int root1 = findRoot(arr1);
        int root2 = findRoot(arr2);
        if(isSameSturct(arr1,root1,arr2,root2)){
            System.out.print("Yes");
        }else {
            System.out.print("No");
        }
    }

    /**
     * judge two tress whether they have the same struct.
     * @param arr1
     * @param arr2
     * @return
     */
    public static boolean isSameSturct(TreeNode[] arr1,int root1,TreeNode[] arr2,int root2){
        /* both empty*/
        if(root1 == -1 && root2 == -1){
            return true;
        }
        /* one is empty but anther not */
        if((root1 != -1 && root2 == -1)||(root1 == -1 && root2 != -1)){
            return false;
        }
        /* root node's values are different */
        if(!arr1[root1].character.equals(arr2[root2].character)){
            return false;
        }

        if(arr1[root1].left == -1 && arr2[root2].left == -1){
            return isSameSturct(arr1,arr1[root1].right,arr2,arr2[root2].right);
        }

        if((arr1[root1].left != -1 && arr2[root2].left != -1) && (arr1[arr1[root1].left].character.equals(arr2[arr2[root2].left].character))){
            return (isSameSturct(arr1,arr1[root1].left,arr2,arr2[root2].left) && isSameSturct(arr1,arr1[root1].right,arr2,arr2[root2].right));
        }else {
            return (isSameSturct(arr1,arr1[root1].left,arr2,arr2[root2].right)&& isSameSturct(arr1,arr1[root1].right,arr2,arr2[root2].left));
        }
    }

    /**
     * read the input data and initialize the tree.
     * @return
     */
    public static TreeNode[] read(){
        Scanner in = new Scanner(System.in);
        int num = 0;
        String character = null;
        String left;
        String right;

        num =  Integer.parseInt(in.next());

        TreeNode[] arr = new TreeNode[num];

        /* Initialization */
        for(int i = 0;i < num; i ++){
            arr[i] = new TreeNode();
        }

        /* deal with the input data*/
        for(int i = 0;i < num; i ++){
            character = in.next();
            arr[i].character = character;
            left = in.next();
            if(!left.equals("-")){
                arr[i].left = Integer.parseInt(left);
            }
            right = in.next();
            if (!right.equals("-")){
                arr[i].right = Integer.parseInt(right);
            }
        }

        return arr;
    }

    /**
     * find the root index of the tree.
     * @param arr
     * @return
     */
    public static int findRoot(TreeNode[] arr){
        int root = -1;
        int left = -1;
        int right = -1;

        for (int i = 0; i < arr.length; i ++){
            left = arr[i].left;
            if (left != -1){
                arr[left].parent = i;
            }
            right = arr[i].right;
            if(right != -1){
                arr[right].parent = i;
            }
        }

        for (int i = 0;i < arr.length; i ++){
            if (arr[i].parent == -1){
                root = i;
                break;
            }
        }
        return root;
    }
}

class TreeNode{
    public String character;
    public int left;
    public int right;
    public int parent;

    public TreeNode(){
        this.character = null;
        this.left = -1;
        this.right = -1;
        this.parent = -1;
    }

    public TreeNode(String character,int left,int right){
        this.character = character;
        this.left = left;
        this.right = right;
    }


}
