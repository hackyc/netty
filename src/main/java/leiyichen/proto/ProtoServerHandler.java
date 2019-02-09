package leiyichen.proto;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import leiyichen.proto.Datainfo.Person;

public class ProtoServerHandler extends SimpleChannelInboundHandler<Person> {

  @Override
  protected void channelRead0(ChannelHandlerContext ctx, Person msg) throws Exception {
    System.out.println(msg.getId());
    System.out.println(msg.getName());
    System.out.println(msg.getEmail());
  }
}
