
package java2zmp3;

import java.io.FileInputStream;
import javazoom.jl.player.Player;


public class Java2zmp3 {

    public static void main(String[] args) {

        new Welcome().setVisible(true);
        int i=0;
        
        do{
        try{
            FileInputStream file = new FileInputStream("C:\\Users\\Rana_CSE\\Desktop\\bolna.mp3");
            Player playmp3=new Player(file);
            playmp3.play();
           
        }catch(Exception e){
        
        }
        
        }while(i<10);
    
        
        
        
        
        
        
        
    }
    
}