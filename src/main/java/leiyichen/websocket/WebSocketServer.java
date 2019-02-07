package leiyichen.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import java.net.InetSocketAddress;

public class WebSocketServer {
  public static void main(String[] args) throws Exception {

    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap();
      serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
          .childHandler(new WebSocketServerInitializer());
      ChannelFuture channelFuture = serverBootstrap.bind(new InetSocketAddress(8899)).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workGroup.shutdownGracefully();
    }
  }
}
