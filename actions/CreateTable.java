package actions;
import java.util.*;
import com.google.gson.Gson;

public class CreateTable {
    
    private HashMap<String,ArrayList<?>> column = new HashMap<String,ArrayList<?>>();
    private String tableName;
     
    public CreateTable()
    {

    }

    public String createTable (String cmdArr[])
    {
      if(isValid(cmdArr))
      {
          this.tableName = cmdArr[1];
          String cmd = String.join(" ", cmdArr);
          String cmdInsideCommas = cmd.substring(cmd.indexOf("(")+1, cmd.lastIndexOf(")"));
          String[] columnData = cmdInsideCommas.split(",");
          String remarks = makeTable(columnData);    
          return remarks;

      }

      else
        return "Table can't be created ... possible syntactical errors";
    }
     
    private boolean isValid(String cmdArr[])
    {
      if(cmdArr[0].toUpperCase().equals("CREATE"))
          return true ;
          else

          return  false;

      
    }

    private String makeTable(String[] columnData) {
        for(int i=0; i<columnData.length; i++) {
            String[] dataParts = columnData[i].split(" ");
            ArrayList<String> cols = new ArrayList<String>();
            column.put(dataParts[0], cols);
        }

        return this.convertGson();
        
    }

    private String convertGson() {
        Gson gson=new Gson();
        String json=gson.toJson(this);
        
        return json;
    }   

   
}

