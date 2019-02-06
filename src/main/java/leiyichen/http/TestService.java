package leiyichen.http;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * Netty测试启动类 各种回调有点恶心
 */
public class TestService {

  public static void main(String[] args) throws Exception {
    // 1.启动NIO组 相当于是个死循环 一直轮询任务 2.boss用来接收 work用来打工
    EventLoopGroup bossGroup = new NioEventLoopGroup();
    EventLoopGroup workGroup = new NioEventLoopGroup();
    try {
      ServerBootstrap serverBootstrap = new ServerBootstrap();
      // 3.booStrap启动 启动NioServiceSocketChannel 4.自定义子处理器
      serverBootstrap.group(bossGroup, workGroup).channel(NioServerSocketChannel.class)
          .childHandler(new TestServiceInitializer());
      //5.端口绑定
      ChannelFuture channelFuture = serverBootstrap.bind(8899).sync();
      channelFuture.channel().closeFuture().sync();
    } finally {
      bossGroup.shutdownGracefully();
      workGroup.shutdownGracefully();
    }
  }
}
