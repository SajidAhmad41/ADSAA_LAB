import java.util.*;
public class Selectionsort
{
  public int[] sort(int a[],int n)
  {
     for(int i = 0; i < n - 1; i++) {
    int minIndex = i;
    for(int j = i + 1; j < n; j++) {
        if(a[j] < a[minIndex]) {
            minIndex = j;
        }
    }
        int temp = a[i];
        a[i] = a[minIndex];
        a[minIndex] = temp;
    }
    return a;
   }

  public static void main(String args[])
  {
   	Selectionsort ss=new Selectionsort();
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
  	 System.out.println("Selection sort result:");
        int[] sortedArray = ss.sort(a, n);
        for (int i = 0; i < n; i++)
         {
            System.out.print(sortedArray[i] + " ");
         }
  }
}
 	
     	
