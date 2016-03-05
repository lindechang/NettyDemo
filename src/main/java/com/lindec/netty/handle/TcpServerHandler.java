package com.lindec.netty.handle;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;


/**
 * Created by lindec on 2016/3/5 17:21.
 */
public class TcpServerHandler extends SimpleChannelInboundHandler<Object> {

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
                                Throwable cause) throws Exception {
        System.out.println("Unexpected exception from downstream."+cause);
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("SERVER接收到消息:"+msg);
        ctx.channel().writeAndFlush("yes, server is accepted you ,nice !"+msg);
    }
}