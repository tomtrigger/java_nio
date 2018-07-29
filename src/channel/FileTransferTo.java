package channel;

import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;

public class FileTransferTo {

    public static void main(String[] args) throws Exception {
        RandomAccessFile fromFile = new RandomAccessFile("D:\\Java study\\workspace\\java_nio\\src\\fromFile.txt", "rw");
        FileChannel fromFileChannel = fromFile.getChannel();
        RandomAccessFile toFile = new RandomAccessFile("D:\\Java study\\workspace\\java_nio\\src\\toFile.txt", "rw");
        FileChannel toFileChannel = toFile.getChannel();
        long position = 0L;
        long size = fromFileChannel.size();
        long length = fromFileChannel.transferTo(position, size, toFileChannel);
        System.out.println(length);
        fromFile.close();
        toFile.close();
    }

}
