import java.io.*;
import java.awt.*;
public class ReadStudentFile extends Frame
{
    TextField number, name, marks;
    Button enter, done;
    Label numLabel, nameLabel, markLabel;
    DataInputStream dis;
    boolean moreRecords=true;
    
    public ReadStudentFile()
    {
        super ("Create Student File");
        
    }
    
    public void setup()
    {
        resize(500,300);
        setLayout (new GridLayout(4,2));
        number=new TextField(20);
        numLabel=new Label("Roll Number: ");
        name=new TextField(20);
        nameLabel=new Label("Student Name: ");
        marks=new TextField(20);
        markLabel=new Label("Marks: ");
        
        enter=new Button("ENTER");
        done=new Button("DONE");
        
        add(numLabel);
        add(number);
        add(nameLabel);
        add(name);
        add(markLabel);
        add(marks);
        add(enter);
        add(done);
        
        show();
        try
        {
            dis=new DataInputStream (new FileInputStream ("student.dat"));
            
        }
        
        catch(IOException e)
                {
                    System.err.println(e.toString());
                    System.exit(1);
                }
    }
    public void readRecord()
    {
        int n;
        String s;
        double d;
        
        try
        {
            n=dis.readInt();
            s=dis.readUTF();
            d=dis.readDouble();
            number.setText(String.valueOf(n));
            name.setText(String.valueOf(s));
            marks.setText(String.valueOf(d));
        }
        catch(EOFException e)
        {
            moreRecords=false;
        }
        catch(IOException ioe)
        {
            System.out.println("IO Error");
            System.exit(1);
        }
    }
    
    public void cleanup()
    {
        
        try
        {
            dis.close();
        }
        
        catch(IOException e)
        {}
    }
    
    public boolean action (Event event, Object o)
    {
        if(event.target instanceof Button)
        {
            if(event.arg.equals("NEXT"))
            {
                readRecord();
            }
        }
        return true;
    }
        
        public boolean handleEvent(Event event)
        {
            if(event.arg.equals("DONE")||moreRecords==false)
            {
                cleanup();
                System.exit(0);
                return true;
            }
            return super.handleEvent(event);
        }
        
        public static void main(String args[])
        {
            ReadStudentFile student=new ReadStudentFile();
            student.setup();
    }
}
