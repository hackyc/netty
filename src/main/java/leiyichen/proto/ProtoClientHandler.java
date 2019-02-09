package leiyichen.proto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import leiyichen.proto.Datainfo.Person;

public class ProtoClientHandler extends SimpleChannelInboundHandler<Person> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {

  }

  @Override
  public void channelActive(ChannelHandlerContext ctx) throws Exception {
    Person info = Person.newBuilder().setName("leiyichen").setEmail("2312@qq.com")
        .setId(1).build();
    ctx.channel().writeAndFlush(info);
  }
}
