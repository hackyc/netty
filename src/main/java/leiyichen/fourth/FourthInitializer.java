package leiyichen.fourth;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.timeout.IdleStateHandler;
import java.util.concurrent.TimeUnit;

public class FourthInitializer extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ch.pipeline().addLast(new IdleStateHandler(5,7,10,TimeUnit.SECONDS))
        .addLast(new FourthHandler());
  }
}
