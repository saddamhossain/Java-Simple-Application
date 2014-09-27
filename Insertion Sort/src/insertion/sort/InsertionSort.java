
package insertion.sort;

/**
 *
 * @author RANA_CSE
 */
public class InsertionSort 

{

    
    public static void main(String[] args) 
    {
        // TODO code application logic here
        int i;
        int[] array = {4,9,6,3,10,63,7,12,13,1};
        
        System.out.println("Insertion sort: \n");
        System.out.println("Values before the sort: ");
        for(i=0;i<array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
        insertion_sort(array,array.length);
        System.out.println();
        System.out.println("Values after the sort: ");
        
        for(i=0;i<array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
        System.out.println();
    
        
    }
    
  public static void insertion_sort(int[] array, int n)
    {
     int tmp,i,j;

   for (j=1; j<n; j++) 
        {
       i =j - 1;
       tmp = array[j];
       while ( (i>=0) && (tmp < array[i]) ) 
       {
           array[i+1] = array[i];
           i--;
       }
       array[i+1] = tmp;
       }
   }
}
