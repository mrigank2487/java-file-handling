import java.io.*;
public class WriteBytes 
{
    public static void main(String args[])
    {
        byte cities[]={'D','E', 'L', 'H', 'I', '\n', 'M', 'A', 'D', 'R', 'A', 'S', '\n', 'L', 'O', 'N', 'D', 'O', 'N', '\n'};
        FileOutputStream outfile=null;
        
        try
        {
            outfile=new FileOutputStream("C:\\Users\\Sandeep\\Desktop\\Java\\cities.txt");
            outfile.write(cities);
            outfile.close();
        }
        catch (IOException ioe)
        {
            System.out.println(ioe);
            System.exit(-1);
        }
        
        FileInputStream infile=null;
        int b;
        try
        {
            infile=new FileInputStream("C:\\Users\\Sandeep\\Desktop\\Java\\cities.txt");
            while ((b=infile.read())!=-1)
            {
                System.out.print((char)b);
            }
            infile.close();
        }
        catch(IOException ioe)
        {
            System.out.println(ioe);
        }
       
    }
}
