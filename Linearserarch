import java.util.*;

class linear {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int a[] = new int[n];
        System.out.println("Enter the " + n + " elements:");
        
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        
        System.out.println("Enter the key to search for:");
        int key = sc.nextInt();
        
        int p = linearsearch(a, key);
        
        if (p == -1) {
            System.out.println("Key not found!");
        } else {
            System.out.println("Key found at index " + p);
        }
    }
    
    public static int linearsearch(int a[], int key) {
        for (int i = 0; i < a.length; i++) {
            if (a[i] == key) {
                return i; 
            }
        }
        return -1; 
    }
}
