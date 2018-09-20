import java.io.*;
import java.awt.*;
public class StudentFile extends Frame
{
    TextField number, name, marks;
    Button enter, done;
    Label numLabel, nameLabel, markLabel;
    
    DataOutputStream dos;
    
    public StudentFile()
    {
        super ("Create Student File");
        
    }
    
    public void setup()
    {
        resize(500,300);
        setLayout (new GridLayout(4,8));
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
            dos=new DataOutputStream (new FileOutputStream ("student.dat"));
            
        }
        
        catch(IOException e)
                {
                    System.err.println(e.toString());
                    System.exit(1);
                }
    }
    public void addRecord()
    {
        int num;
        double d;
        num=Integer.parseInt(number.getText());
        try
        {
            dos.writeInt(num);
            dos.writeUTF(name.getText());
            d=Double.parseDouble(marks.getText());
            dos.writeDouble(d);
        }
        catch(IOException e)
        {
            
        }
        number.setText(" ");
        name.setText(" ");
        marks.setText(" ");
    }
    
    public void cleanup()
    {
        if(!number.getText().equals(" "))
            addRecord();
        try
        {
            dos.flush();
            dos.close();
        }
        
        catch(IOException e)
        {}
    }
    
    public boolean action (Event event, Object o)
    {
        if(event.target instanceof Button)
        {
            if(event.arg.equals("ENTER"))
            {
                addRecord();
                return true;
                
            }
        }
        return super.action(event,o);
    }
        
        public boolean handleEvent(Event event)
        {
            if(event.arg.equals("DONE"))
            {
                cleanup();
                System.exit(0);
                return true;
            }
            return super.handleEvent(event);
        }
        
        public static void main(String args[])
        {
            StudentFile student=new StudentFile();
            student.setup();
    }
}
