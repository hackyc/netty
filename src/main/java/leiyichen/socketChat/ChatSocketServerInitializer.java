package leiyichen.socketChat;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.DelimiterBasedFrameDecoder;
import io.netty.handler.codec.Delimiters;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;
import io.netty.util.CharsetUtil;

public class ChatSocketServerInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
      ch.pipeline().addLast(new DelimiterBasedFrameDecoder(4096,Delimiters.lineDelimiter()))
          .addLast(new StringEncoder(CharsetUtil.UTF_8))
          .addLast(new StringDecoder(CharsetUtil.UTF_8))
          .addLast(new ChatSocketServerHandle());

  }
}
