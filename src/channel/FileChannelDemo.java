package channel;

import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class FileChannelDemo {

    public static void main(String[] args) throws Exception {
        RandomAccessFile accessFile = new RandomAccessFile("D:\\Java study\\workspace\\java_nio\\.idea\\encodings.xml", "rw");
        FileChannel channel = accessFile.getChannel();
        // create buffer with capacity of 48 bytes
        ByteBuffer buffer = ByteBuffer.allocate(48);
        int read = channel.read(buffer); // read into buffer
        while (read != -1) {
            System.out.println("Read:" + read);
            buffer.flip(); // make buffer ready for read
            while (buffer.hasRemaining()) {
                System.out.print((char) buffer.get()); // read 1 byte at a time
            }
            buffer.clear(); // make buffer ready for writing
            read = channel.read(buffer);
        }
        accessFile.close();
    }

}
