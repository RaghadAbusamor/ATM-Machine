
package atm;

import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
 

/**
 *
 * @author raghad & ayat
 */
public class MyLogger implements Log{

  
    @Override
    public void log(String message) {
        FileWriter fw= null;
        try{
            fw = new FileWriter("log.txt", true);
            fw.write(LocalDateTime.now().toString() + "------------"+"\t" + message + "\n"+"\n");
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
    
