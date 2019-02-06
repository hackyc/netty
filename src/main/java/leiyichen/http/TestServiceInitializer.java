package leiyichen.http;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServiceInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ChannelPipeline pipeline = ch.pipeline();
    //1.netty默认自带的处理器 编码解码
    pipeline.addLast("httpServerCodec", new HttpServerCodec())
        .addLast("testHttpServiceHandler", new TestHttpServiceHandler());
  }
}
