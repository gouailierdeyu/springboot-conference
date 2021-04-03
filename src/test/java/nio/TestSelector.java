package nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * UTF-8
 * Created by czy  Time : 2021/1/18 9:59
 *
 * @version 1.0
 */
public class TestSelector {
    public static void main(String[] args) throws IOException {
        Selector open = Selector.open();

    }

    /**
     * 这样是没有返回结果的，因为对面的服务器sokcet并没有写入数据，这边当然就读不出来
     * 想要有数据返回其实一应该把这个客户端socket做http请求报文，就是写入http请求相关的数据，然后就会有回应了
     * @throws IOException
     */
    @Test
    public void testSocketChannel() throws IOException {
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.connect(new InetSocketAddress("150.95.139.127", 80));
        ByteBuffer buf = ByteBuffer.allocate(48);
        int read = socketChannel.read(buf);
        while (read!=-1){
            System.out.println(buf.asCharBuffer().toString());
            socketChannel.read(buf);
            System.out.println("sss");

        }
        System.out.println("rrr");
        System.out.println(buf.asCharBuffer().toString());
        CharBuffer cbuf = StandardCharsets.UTF_8.decode(buf);
        System.out.println(cbuf.toString());
        socketChannel.close();

    }

    @Test
    public void testFileCHannel(){
        RandomAccessFile aFile = null;
        try{
            aFile = new RandomAccessFile("E:\\study\\java\\conference\\target\\classes\\conference\\ProStart.class","rw");
            FileChannel fileChannel = aFile.getChannel();
            ByteBuffer buf = ByteBuffer.allocate(1024);
            int bytesRead = fileChannel.read(buf);
            ArrayList<Byte> Bytes = new ArrayList<>();

            while(bytesRead != -1)
            {
                buf.flip();
                while(buf.hasRemaining())
                {
                    Bytes.add(buf.get());
                }

                buf.clear();
                bytesRead = fileChannel.read(buf);
            }
            byte [] bytes=new byte[Bytes.size()];
            for (int i = 0; i < Bytes.size(); i++) {
                bytes[i]=Bytes.get(i);
            }
            CharBuffer decode = StandardCharsets.UTF_8.decode(ByteBuffer.wrap(bytes));
            System.out.println(decode);

        }catch (IOException e){
            e.printStackTrace();
        }finally{
            try{
                if(aFile != null){
                    aFile.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }

    }
}
