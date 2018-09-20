import java.io.*;
class SequenceBuffer 
{
    public static void main(String args[]) throws IOException
    {
        FileInputStream file1=null;
        FileInputStream file2=null;
        
        file1=new FileInputStream("C:\\Users\\Sandeep\\Desktop\\Java\\BarChart.java");
        file2=new FileInputStream("C:\\Users\\Sandeep\\Desktop\\Java\\HelloJavaParam.java");
        SequenceInputStream file3=null;
        file3=new SequenceInputStream (file1,file2);
        BufferedInputStream inBuffer=new BufferedInputStream(file3);
        BufferedOutputStream outBuffer=new BufferedOutputStream(System.out);
        
        int ch;
        while((ch=inBuffer.read())!=-1)
        {
            outBuffer.write((char)ch);
        }
        inBuffer.close();
        outBuffer.close();
        file1.close();
        file2.close();
    }
}
