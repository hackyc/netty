package leiyichen.websocket;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * ChunkedWriteHandler 这个handler主要用于处理大数据流,比如一个1G大小的文件如果你直接传输肯定会撑暴jvm内存的 HttpObjectAggregator
 * http消息聚合
 */
public class WebSocketServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ch.pipeline().addLast(new HttpServerCodec())
        .addLast(new ChunkedWriteHandler())
        .addLast(new HttpObjectAggregator(8192))
        .addLast(new WebSocketServerProtocolHandler("/ws"))
        .addLast(new WebSocketHandler());
  }
}
