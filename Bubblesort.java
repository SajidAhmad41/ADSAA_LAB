import java.util.*;
public class Bubblesort
{
  public int[] sort(int a[],int n)
  {
     for(int i=0;i<n;i++)
     {
     	for(int j=0;j<n-i-1;j++)
     	{
     		if(a[j]>a[j+1])
     		{
     			int temp=a[j];
     			a[j]=a[j+1];
     			a[j+1]=temp;
     		}
     	}
     }
     return a;
  }
  public static void main(String args[])
  {
  	Bubblesort bs=new Bubblesort();
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
  	 System.out.println("Bubble sort result:");
        int[] sortedArray = bs.sort(a, n);
        for (int i = 0; i < n; i++)
         {
            System.out.print(sortedArray[i] + " ");
         }
  }
}
 	
     	
