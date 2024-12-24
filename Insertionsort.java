import java.util.*;
public class Insertionsort{
    public int[] sort(int a[], int n) {
        for (int i = 1; i < n; i++) {
            int key = a[i];
            int j = i - 1;  
            while (j >= 0 && a[j] > key) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = key;
        }
        return a;
    }

  public static void main(String args[])
  {
   	Insertionsort is=new Insertionsort();
  	Scanner sc=new Scanner(System.in);
  	int n;
  	System.out.println("enter the size of array:");
  	n=sc.nextInt();
  	int[] a=new int[n];
  	System.out.println("enter the array elements:");
  	for(int i=0;i<n;i++)
  	{
  		a[i]=sc.nextInt();
  	}
  	 System.out.println("Insertion sort result:");
        int[] sortedArray = is.sort(a, n);
        for (int i = 0; i < n; i++)
         {
            System.out.print(sortedArray[i] + " ");
         }
  }
}
 	
     	
