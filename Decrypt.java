import java.io.EOFException;
import java.io.RandomAccessFile;

class Decrypt {
	public static void main(String args[]) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("targetfile.xml", "r");    
		long count = raf.length();
		long num = raf.length();
		long pos = raf.length();
		pos -= count;
		if (pos < 0)
			pos = 0;
		raf.seek(pos);
		while (true) {
			try {
				byte b = raf.readByte();
				byte bb = (byte) (b ^ num);
				System.out.print((char) bb);
				num--;
			} catch (EOFException eofe) {
				break;
			}
		}
		raf.close();

	}
}
