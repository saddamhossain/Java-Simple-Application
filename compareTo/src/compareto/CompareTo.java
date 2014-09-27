
package compareto;


public class CompareTo 
{

   static  String array[] = {"Now", "is", "the", "time", "all", "good", "men", "to",
                       "come", "to", "the","aid","of","thier","country"};
    
    public static void main(String[] args)
    {
        // TODO code application logic here
        for(int i = 0; i<array.length;i++)
            {
               for(int j=i+1;j<array.length;j++)
                   {
                       if(array[j].compareTo(array[i])<0)
                        {
                            String t = array[i];
                            array[i] = array[j];
                            array[j] = t;
                        }
                   }
             System.out.print(" "+array[i]); 
            }
    }
}
