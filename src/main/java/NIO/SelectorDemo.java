package NIO;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangzengjian
 * @Description
 * @date 2017/6/17 16:08
 */
public class SelectorDemo {

	public static void main(String[] args) {
		try {
			// 1.打开ServerSocketChannel
			ServerSocketChannel ssc = ServerSocketChannel.open();
			// 2.绑定监听地址
			ssc.socket().bind(new InetSocketAddress("127.0.0.1", 8000));
			ssc.configureBlocking(false);
			// 3.创建Selector
			Selector selector = Selector.open();
			// 4.注册 channel，并且指定感兴趣的事件是 Accept
			ssc.register(selector, SelectionKey.OP_ACCEPT);

			ByteBuffer readbuf = ByteBuffer.allocate(1024);
			ByteBuffer writebuf = ByteBuffer.allocate(128);
			writebuf.put("received".getBytes());
			writebuf.flip();

			while (true) {
				selector.select();
				// 5.Selector轮询就绪key
				Set<SelectionKey> selectionKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectionKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					iterator.remove();
					// 6.处理新的客户端接入
					if (key.isAcceptable()) {
						// 7.
						SocketChannel channel = ssc.accept();
						channel.configureBlocking(false);
						// 8.
						channel.register(selector, SelectionKey.OP_READ);
					} else if (key.isReadable()) {
						SocketChannel channel = (SocketChannel) key.channel();
						readbuf.clear();
						channel.read(readbuf);
						readbuf.flip();
						System.out.println("received : " + new String(readbuf.array()));
						key.interestOps(SelectionKey.OP_WRITE);
					} else if (key.isWritable()) {
						writebuf.rewind();
						SocketChannel channel = (SocketChannel) key.channel();
						channel.write(writebuf);
						key.interestOps(SelectionKey.OP_READ);
					}
				}

			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
