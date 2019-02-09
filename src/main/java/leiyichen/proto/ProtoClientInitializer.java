package leiyichen.proto;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.protobuf.ProtobufDecoder;
import io.netty.handler.codec.protobuf.ProtobufEncoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder;
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender;
import leiyichen.proto.Datainfo.Person;

public class ProtoClientInitializer  extends ChannelInitializer<SocketChannel> {

  @Override
  protected void initChannel(SocketChannel ch) throws Exception {
    ch.pipeline().addLast().addLast(new ProtobufVarint32FrameDecoder())
        .addLast(new ProtobufDecoder(Person.getDefaultInstance()))
        .addLast(new ProtobufVarint32LengthFieldPrepender())
        .addLast(new ProtobufEncoder()).addLast(new ProtoClientHandler());
  }
}
