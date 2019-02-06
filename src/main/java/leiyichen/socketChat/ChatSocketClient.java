package leiyichen.socketChat;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 客户端
 */
public class ChatSocketClient {

  public static void main(String[] args) throws Exception {
    EventLoopGroup eventLoopGroup = new NioEventLoopGroup();
    try {
      Bootstrap bootstrap = new Bootstrap();
      bootstrap.group(eventLoopGroup).channel(NioSocketChannel.class)
          .handler(new ChatSocketClientInitializer());
      Channel  channel = bootstrap.connect("localhost", 8899).sync().channel();
      BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
      while (true){
        channel.writeAndFlush(br.readLine() + "\r\n");
      }
    } finally {
      eventLoopGroup.shutdownGracefully();
    }
  }
}
