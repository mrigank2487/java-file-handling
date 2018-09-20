import java.io.*;
public class ReadWriteRandomAccessFile 
{
    public static void main(String args[]) throws IOException
    {
        RandomAccessFile file=null;
       
        long l=0;
            file=new RandomAccessFile("C:\\Users\\Sandeep\\Desktop\\Java\\RandomAccessFileReadWrite.txt","rw");
            file.writeChar('X');
            file.writeInt(555);
            file.writeDouble(3.1412);
            file.seek(0);
            System.out.println(file.readChar());
            System.out.println(file.readInt());
            System.out.println(file.readDouble());
            file.seek(2);
            System.out.println(file.readInt());
                        
            l=file.length();
            file.seek(l);
            file.writeBoolean(false);
            file.seek(l);
            System.out.println(file.readBoolean());
            file.close();
        
        
    }
}
