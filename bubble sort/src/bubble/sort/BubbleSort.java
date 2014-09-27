
package bubble.sort;

/**
 *
 * @author RANA_CSE
 */
public class BubbleSort 
{

    
    public static void main(String[] args)
    {
        // TODO code application logic here
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
                }
        }
}
   