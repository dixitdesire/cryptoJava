import java.io.EOFException;
import java.io.FileOutputStream;
import java.io.RandomAccessFile;

class Encrypt {
	public static void main(String args[]) throws Exception {
		RandomAccessFile raf = new RandomAccessFile("sourcefile.xml", "r");
		FileOutputStream fos = new FileOutputStream("targetfile.xml");
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
				fos.write(bb);
				num--;
			} catch (EOFException eofe) {
				break;
			}
		}
		fos.close();
		raf.close();
	}
}
