import java.util.Arrays;
import java.util.Scanner;

/**
 * Author:Aravind Meesala
 * Roll No: 2019501037
 * Date: 04-01-2021
 */
public class ThreeSumFast {

    public static int triplets(int [] a){
        int count=0;
        Arrays.sort(a);
        // System.out.println(Arrays.toString(a));
        for (int i=0;i<a.length;i++){       //loop which iterates from 0 to length of the  with N^2 complexity
            int start=i+1;
            int end=a.length-1;
            while (start<end){              // loop continuous till start equals to end  providing N complexity
                if(a[i]+a[start]+a[end]==0){// if triplets =0, count & start must increase by 1 and end must decrease by 1
                    count++;
                    start++;
                    end--;
                }
                else if(a[i]+a[start]+a[end]<0) {start++;}// if not start must only icrease by 1
                else{end--;}                // else end must reduce by 1 this loop provides
                                            //required combinations to increase the count.
            }
        }
        return(count);}

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // your code goes here
        int n=sc.nextInt();
        int[] arr=new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        System.out.println(triplets(arr));
        sc.close();
    }
}
