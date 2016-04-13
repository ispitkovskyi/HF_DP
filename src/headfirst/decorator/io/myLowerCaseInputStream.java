package headfirst.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ispitkovskyi on 3/29/2015.
 */
public class myLowerCaseInputStream extends FilterInputStream {
    /**
     * DECORATOR CLASS
     * Creates a <code>FilterInputStream</code>
     * by assigning the  argument <code>in</code>
     * to the field <code>this.in</code> so as
     * to remember it for later use.
     *
     * @param in the underlying input stream, or <code>null</code> if
     *           this instance is to be created without an underlying stream.
     */
    protected myLowerCaseInputStream(InputStream in) {
        super(in);
    }

    public int read() throws IOException{
        int c = super.read();
        return (c == -1 ? c : Character.toLowerCase((char)c)); //If end of stream reached (-1), return -1, otherwise return readed character
    }

    //Here I'm extending method "read()" to not only read, but also modify each read character in the array of bytes, where each portion of input is placed
    public int read(byte[] b, int offset, int len) throws IOException{
        int result = super.read(b, offset, len);
        for (int i=offset; i<offset + result; i++){
            b[i] = (byte)Character.toLowerCase((char)b[i]); //Convert each character from the readed array of bytes(=chars) to lowercase.
        }
        return result;
    }
}
