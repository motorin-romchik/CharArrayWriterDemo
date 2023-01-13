import java.io.*;
public class CharArrayWriterDemo {
    public static void main (String args[]){
        CharArrayWriter f = new CharArrayWriter();
        String s = "This data should be entered into array!";
        char buf[] = new char[s.length()];

        s.getChars(0,s.length(),buf,0);

        try{
            f.write(buf);

        } catch (IOException e){
            System.out.println(e);
            return;
        }

        System.out.println("Buffer in string");
        System.out.println(f.toString());
        System.out.println("INto Array:");

        char c[] = f.toCharArray();

        for (int h = 0; h < c.length; h++){
            System.out.println(c[h]);
        }

        System.out.println("Stream FileWriter:");

        try(FileWriter f2 = new FileWriter("test.txt")){
            f.writeTo(f2);
        }catch (IOException e){
            System.out.println(e);
        }
        f.reset();

        for(int k=0; k < 3;k++){
            f.write('X');

        }
        System.out.println(f.toString());
        f.reset();

        System.out.println("File reading!");
        int g;
        try(FileReader re = new FileReader("test.txt")){
            while((g = re.read()) != -1){
                System.out.print((char) g);
            }
        }catch (FileNotFoundException e){
            System.out.println(e);
        } catch (IOException e){
            System.out.println(e);
        }
    }
}
