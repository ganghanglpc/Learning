import java.util.Scanner;

public class PopSequence {

    public static void main(String args[]){
        Scanner in = new Scanner(System.in);
        int M;
        int N;
        int num;
        M = Integer.parseInt(in.next());
        N = Integer.parseInt(in.next());
        num = Integer.parseInt(in.next());
        int[][] arr = new int[num][N];
        String[] reslut = new String[num];

        for(int i = 0;i<num;i++){
            for (int j = 0;j<N;j++){
                arr[i][j] = Integer.parseInt(in.next());
            }
        }

        for (int i = 0;i<num;i++){
            reslut[i] = "YES";
        }

        for(int i = 0;i<num;i++){
            int max = arr[i][0];
            int temp = max;
            for (int j = 0;j<N;j++){
                if(arr[i][j] > max) {
                    temp = max;
                    max = arr[i][j];
                }

                if (arr[i][j] > M + j){
                    reslut[i] = "NO";
                    break;
                }

                if(j < N-1){
                    if ((arr[i][j]) > arr[i][j+1]){
                        int dis = arr[i][j] - arr[i][j+1];
                        if(dis > j + 1 || ((max - temp) > 1 && dis > 1)){
                            reslut[i] = "NO";
                            break;
                        }
                    }
                }

            }
        }

        for (int i = 0 ;i<num;i++){
            System.out.println(reslut[i]);
        }

    }
}
