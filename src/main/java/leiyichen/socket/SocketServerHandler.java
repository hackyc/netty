package leiyichen.socket;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import java.util.UUID;

public class SocketServerHandler extends SimpleChannelInboundHandler<String> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
    System.out.println(ctx.channel().remoteAddress() + "------" + msg);
    ctx.channel().writeAndFlush("hello client:" + UUID.randomUUID());
  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
  }
}
