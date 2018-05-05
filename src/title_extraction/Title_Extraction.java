package title_extraction;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

/**
 *
 * @author K i s h
 */
public class Title_Extraction 
{
   public static void main(String[] args) throws Exception 
   {  
        File folder = new File("E:\\Tutorials\\SQL_KudVenkat"); //Path of dir
        File[] listOfFiles = folder.listFiles(); // list of files in dir 
        int lastIndex, period; // lastIndex of _ and period . to skip file extension
        String intValue; // parse integer value in the file (to sort)
        for(File s: listOfFiles){ // parse each file name and process it
            File temp = null;
            if(s.isFile())
            {
                String FileName = s.getAbsolutePath();
                System.out.println(FileName);
//                String Filess = s.getParent();
//                System.out.println(Filess);
                FileName = FileName.toLowerCase();
                String arr[] = FileName.split(" |\\.");
                int partnum = 0,partindex = 0, flag = 0;
                //Now extract the part number from the above array
                for(int i = 0; i< arr.length; i++){
                    if(arr[i].equalsIgnoreCase("part")){
                        partindex = i+1;
                        flag = 1;
                        break;
                    }
                }
                if(flag == 1){
                    partnum = Integer.parseInt(arr[partindex]);
                    temp = new File ( s.getParent()+'\\'+Integer.toString(partnum) + '_' + s.getName() );
		}
                System.out.println("temp: "+temp);
                try{
                    boolean status = s.renameTo(temp);
                    if(status)
                    {
                        System.out.println("renamed-True");
                    }else
                    {
                        System.out.println("renamed-False");
                    }	
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }    
}
