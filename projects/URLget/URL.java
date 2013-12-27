import java.util.*;

public class URL
{
    private String url;
    private Map<String, String> map;
    
    public URL(String url)
    {
        this.url = url;
        
        String split[] = url.split("\\?");
    
        String querry = split[1];
    
        String fields[] = querry.split("\\&");
    
        map = new HashMap<String, String>();
    
        for ( int i = 0; i < fields.length; i++)
        {
            String fValues[] = fields[i].split("\\=");
            map.put( fValues[0], fValues[1]);  
        }
    }

    public String get(String input)
    {
        if( map.containsKey( input ) )
        {
            return map.get(input);
        }
    
        else
        {
            return null;
        }
    }
}