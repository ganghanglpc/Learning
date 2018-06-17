import org.dom4j.Document;

/**打印M图形（有瑕疵）
 *
 */
public class demo2 {

    public static void main(String agrs[]){
        int num = 100;
        int width = num;
        int height = width/4 + 1;
        int x = height - 1;
        int y = 0;

        int[][] arr = new int[height][width];
        boolean flag = false;

        for(int i = 1;i <= num;i ++){
            arr[x][y] = i;
            y++;

            if(!flag){
                x--;
            }
            if (flag){
                x++;
            }
            if(x<1){
                flag = true;
            }
            if(x>(height-2)){
                flag = false;
            }
        }

        for(int i = 0;i<arr.length;i++){
            for(int j = 0;j <arr[i].length;j++){
                if (arr[i][j] == 0){
                    System.out.print("  ");
                }else{
                    System.out.print(arr[i][j]);
                }
            }
            System.out.println();
        }
    }
}
