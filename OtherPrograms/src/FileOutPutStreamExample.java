import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutPutStreamExample {
	public static void main(String[] args) throws FileNotFoundException, IOException{
		String filename="D:\\lyrics.txt";
		
		try(FileOutputStream fos=new FileOutputStream(filename)){
			
			String lines="\nThis is a FILEOUTPUTSTREAM test program\n";
			byte[] t=lines.getBytes();
			fos.write(t);
		}
	}

}
