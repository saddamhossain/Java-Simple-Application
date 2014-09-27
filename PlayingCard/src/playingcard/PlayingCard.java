
package playingcard;

/**
 *
 * @author RANA_CSE
 */
public class PlayingCard implements Compareable<PlayingCard>
{
     private int suit;
     private int number;
     
     public int compareTo(PlayingCard o) 
     {
        if (this.suit < o.suit) 
            {
               return -1;
            } 
        else if (this.suit > o.suit) 
             {
                return 1;
             } 
        else
        {
            if (this.number < o.number)
                {
                    return -1;
                } 
            else if (this.number > o.number) 
                {
                    return 1;
                } 
            else 
            {
                return 0;
            }
        }
   
    
    }
     /* public static final int suit_spades=1;
      public static final int suit_hearts=2;
      public static final int suit_clubs=3;
      public static final int suit_diamonds=4;
      
      public static final int number_1 = 2;
      public static final int number_2 = 3;
      public static final int number_3 = 4;
      public static final int number_4 = 5;
      public static final int number_5 = 6;
      public static final int number_6 = 7;
      public static final int number_7 = 8;
      public static final int number_8 = 9;
      public static final int number_9 = 10;
      
      
      
      
     */
      
    
    public static void main(String[] args) 
    {
       PlayingCard obj = new PlayingCard();
        
    }
}
