
package ATM;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;

/**
 *
 * @author apauser
 */
public class MyLogger implements Log{

  
    public void log(String message) {
        FileWriter fw= null;
        try{
            fw = new FileWriter("log.txt", true);
            fw.write(LocalDateTime.now().toString() + "------------" + message + "\n");
        }
        catch(IOException ex){
           System.out.println(ex);
        }
        finally{
            try{
                fw.close();
            }
            catch(IOException ex){
                System.out.println(ex);
            }
            
        }
    }
    
}
    
