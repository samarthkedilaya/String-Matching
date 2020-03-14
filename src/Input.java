import java.io.*;

public class Input
{
    String ipString = "";
    Input(String fileName)
    {
        try
        {
          this.ipString = readFile(fileName);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
    String readFile(String fileName) throws IOException
    {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        try
        {
            StringBuilder sb = new StringBuilder(); String line = br.readLine();
            while (line != null)
            {
                sb.append(line).append("\n");
                line = br.readLine();
            }
            return sb.toString();
        }
        finally
        {
            br.close();
        }
    }
}