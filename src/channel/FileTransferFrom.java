package channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileTransferFrom {

    public static void main(String[] args) throws Exception {
        RandomAccessFile toFile = new RandomAccessFile("D:\\Java study\\workspace\\java_nio\\src\\toFile.txt", "rw");
        FileChannel toChannel = toFile.getChannel();
        RandomAccessFile fromFile = new RandomAccessFile("D:\\Java study\\workspace\\java_nio\\src\\fromFile.txt", "rw");
        FileChannel fromChannel = fromFile.getChannel();
        long position = 0L;
        long size = fromChannel.size();
        long length = toChannel.transferFrom(fromChannel, position, size);
        System.out.println(length);
        toFile.close();
        fromFile.close();
    }

}
