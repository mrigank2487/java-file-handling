import java.io.*;
public class CopyCharacters 
{
    public static void main(String args[])
    {
        File inFile=new File ("C:\\Users\\Sandeep\\Desktop\\Java\\Bar.html");
        File outFile=new File("C:\\Users\\Sandeep\\Desktop\\Output.txt");
        FileReader ins=null;
        FileWriter outs=null;
        try
        {
            ins=new FileReader(inFile);
            outs=new FileWriter(outFile);
            int ch;
            while((ch=ins.read())!=-1)
            {
                outs.write(ch);
            }
        }
        catch (IOException e)
                {
                    System.out.println(e);
                    System.exit(-1);
                }
        finally
        {
            try
            {
                ins.close();
                outs.close();
            }
            catch (IOException e)
            {}
        }
    }
}
