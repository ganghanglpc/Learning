import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class demo3 {

    public static void main(String agrs[]) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int m = Integer.parseInt(in.next());

        int[] arr = new int[n];
        for (int i = 0;i < n; i ++){
            arr[i] = Integer.parseInt(in.next());
        }

        //System.out.println(arr[3]);

        int num;
        if (m < n) {
            num = m;
        } else {
            num = m % n;
        }

        for (int i = 0; i < num;i ++){
            demo3.move(arr,n);
        }

        for (int i = 0;i < arr.length;i ++){
            System.out.print(arr[i] + "\t");
        }



    }

    public static void move(int[] arr,int n){
        int temp = arr[n-1];

        for (int i = n - 2; i >= 0;i --){
            arr[i + 1] = arr[i];
        }
        arr[0] = temp;
    }
}
