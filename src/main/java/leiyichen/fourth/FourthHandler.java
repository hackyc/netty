package leiyichen.fourth;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

public class FourthHandler extends ChannelInboundHandlerAdapter {

  @Override
  public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
    String value = "";
    if (evt instanceof IdleStateEvent) {
      IdleStateEvent idleStateEvent = (IdleStateEvent) evt;
      switch (idleStateEvent.state()) {
        case ALL_IDLE:
          value = "读写超时";
          break;
        case READER_IDLE:
          value = "读超时";
          break;
        case WRITER_IDLE:
          value = "写超时";
          break;
        default:
          value = "不知道什么问题";
      }
    }
    System.out.println(value);
    ctx.channel().close();
  }
}
