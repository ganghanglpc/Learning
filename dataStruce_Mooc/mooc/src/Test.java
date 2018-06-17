public class Test {

    public static void main(String args[]){

        int[] arr = {4,3,2,5,6,1};
        Invide(0,5,arr,0);

    }
    public static void Invide(int left,int right,int[] arr,int flag){
        int num = right - left + 1;
        int sright = 0;
        int temp = 1;
        if(left == right){
            //需要做一步判断是否为最后一个元素（即根元素）输出后面无空格。
            if(arr.length == 1){
                System.out.print(arr[left]);
            }else {
                System.out.print(arr[left] + " ");
            }
        }else{
            int h = (int)(Math.log(num)/Math.log(2)) + 1;
            int h_sum = num - ((int)Math.pow(2,h-1) - 1);
            int left_h_sum = (int)Math.pow(2,h-2);
            if((h_sum - left_h_sum) >= 0){
                sright = left + ((int)Math.pow(2,h-1) - 1) - 1;
            }else{
                sright = left + ((int)Math.pow(2,h-2) - 1) - 1 + left_h_sum;
            }
            int center = sright + 1;
            Invide(left,sright,arr,temp);
            if(center == right){
                Invide(center,right,arr,temp);
            }else {
                Invide(center+1,right,arr,temp);
                if( flag == 0){
                    System.out.print(arr[center]);
                }else {
                    System.out.print(arr[center] + " ");
                }
            }
        }
    }
}
