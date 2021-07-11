package the.flash.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import the.flash.protocol.PacketCodeC;

import java.util.List;

public class PacketDecoder extends ByteToMessageDecoder {

    @Override
    protected void decode(ChannelHandlerContext ctx, ByteBuf in, List out) {
//    	判断协议开头（四个字节）需要在业务解码步骤进行，而不应该放在业务拆包之前。
//    	高频繁的收发数据才能复现~
//    	这里拆包之后处理魔数
        if (in.getInt(in.readerIndex()) != PacketCodeC.MAGIC_NUMBER) {
            ctx.channel().close();
            return;
        }
        out.add(PacketCodeC.INSTANCE.decode(in));
    }
}
