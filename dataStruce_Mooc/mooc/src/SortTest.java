public class SortTest {

    public static void main(String ars[]){
        int[] record = {7,5,3,1,8,4};

        int flag = 0;
        int pos = 0;
        for (int i = 0; i < record.length - 1;i ++){
            int k = i;
            for(int j = i + 1; j < record.length; j ++ ){
                if(record[k] > record[j]) k = j;
            }
            flag ++;
            if (flag == 1){
                pos = k;
            }
            int temp = record[i];
            record[i] = record[k];
            record[k] = temp;
        }

        System.out.println(pos);
        for (int i = 0; i < record.length;i ++){
            System.out.println(record[i]);
        }
    }
}
