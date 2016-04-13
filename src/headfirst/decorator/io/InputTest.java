package headfirst.decorator.io;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class InputTest {
	public static void main(String[] args) throws IOException {
		int c;
		Path myPath = Paths.get(new File("").toURI()).getParent();
		String pathStr = myPath.toString()+ "/chapter3/test.txt";
		BufferedInputStream bis = new BufferedInputStream(new InputStream() {
			@Override
			public int read() throws IOException {
				return 0;
			}
		});

		try {
			InputStream in = 
				new LowerCaseInputStream( //LowerCaseInputStream extends -> FilterInputStream extends -> InputStream
					new BufferedInputStream(
						new FileInputStream(pathStr/*"test.txt"*/))); //FileInputStream extends -> InputStream

			while((c = in.read()) >= 0) {
				System.out.print((char)c);
			}

			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("\n\nNow my implementation is following:\n");
		try{
			InputStream in2 = new FileInputStream(pathStr);
			//Note, that the BufferedInputStream wrapper is not necessary. We can wrap InputStream directly to my decorator "myLowercaseInputStream"
			in2 = new myLowerCaseInputStream(in2);

			int length = 8;
			byte[] b = new byte[length];
			int offset = 0;
			while((c = in2.read(b, 0, 8)) >= 0){
				for(int i=offset; i<c; i++){
					System.out.print((char)b[i]);
				}
			}

		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
