
package multiple.sort;


public class MultipleSort
{

    public void insert()
    {
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
  public void bubble()
  {
  int i;
        int[] array = {40,9,1,99,10,63,7,12,13,19};
        System.out.println("Bubble sort:\n");
        System.out.println("Values before the sort: ");
        for(i=0;i<array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
        bubble_sort(array,array.length);
        System.out.println();
        System.out.println("Values after the sort: ");
        
        for(i=0;i<array.length;i++)
            {
                System.out.print(array[i]+" ");
            }
        System.out.println();
    }
    
    public static void bubble_sort(int[] array, int n)
    
            {
         int tmp,i,j;

                for (i=0; i<n-1; i++) 
                {
                    for (j=0; j<n-i-1; j++)
                    {
                        if (array[j] > array[j+1]) 
                        {
                             tmp = array[j];
                             array[j] = array[j+1];
                             array[j+1] = tmp;
                        }
                    }
                }        }
   
    public static void main(String[] args)
    {
      MultipleSort ob = new MultipleSort();
      ob.insert();
      ob.bubble();
    }
}
