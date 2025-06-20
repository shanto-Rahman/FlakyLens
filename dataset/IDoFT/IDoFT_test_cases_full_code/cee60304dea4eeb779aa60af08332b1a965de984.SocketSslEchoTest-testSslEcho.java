public void testSslEcho(ServerBootstrap sb,Bootstrap cb) throws Throwable {
  reset();
  sb.childHandler(new ChannelInitializer<SocketChannel>(){
    @Override public void initChannel(    SocketChannel sch) throws Exception {
      serverChannel=sch;
      serverSslHandler=serverCtx.newHandler(sch.alloc());
      sch.pipeline().addLast("ssl",serverSslHandler);
      if (useChunkedWriteHandler) {
        sch.pipeline().addLast(new ChunkedWriteHandler());
      }
      sch.pipeline().addLast("handler",serverHandler);
    }
  }
);
  cb.handler(new ChannelInitializer<SocketChannel>(){
    @Override public void initChannel(    SocketChannel sch) throws Exception {
      clientChannel=sch;
      clientSslHandler=clientCtx.newHandler(sch.alloc());
      sch.pipeline().addLast("ssl",clientSslHandler);
      if (useChunkedWriteHandler) {
        sch.pipeline().addLast(new ChunkedWriteHandler());
      }
      sch.pipeline().addLast("handler",clientHandler);
    }
  }
);
  final Channel sc=sb.bind().sync().channel();
  cb.connect().sync();
  final Future<Channel> clientHandshakeFuture=clientSslHandler.handshakeFuture();
  clientChannel.writeAndFlush(Unpooled.wrappedBuffer(data,0,FIRST_MESSAGE_SIZE));
  clientSendCounter.set(FIRST_MESSAGE_SIZE);
  clientHandshakeFuture.sync();
  boolean needsRenegotiation=renegotiation.type == RenegotiationType.CLIENT_INITIATED;
  Future<Channel> renegoFuture=null;
  while (clientSendCounter.get() < data.length) {
    int clientSendCounterVal=clientSendCounter.get();
    int length=Math.min(random.nextInt(1024 * 64),data.length - clientSendCounterVal);
    ByteBuf buf=Unpooled.wrappedBuffer(data,clientSendCounterVal,length);
    if (useCompositeByteBuf) {
      buf=Unpooled.compositeBuffer().addComponent(buf).writerIndex(buf.writerIndex());
    }
    ChannelFuture future=clientChannel.writeAndFlush(buf);
    clientSendCounter.set(clientSendCounterVal+=length);
    future.sync();
    if (needsRenegotiation && clientSendCounterVal >= data.length / 2) {
      needsRenegotiation=false;
      clientSslHandler.engine().setEnabledCipherSuites(new String[]{renegotiation.cipherSuite});
      renegoFuture=clientSslHandler.renegotiate();
      logStats("CLIENT RENEGOTIATES");
      assertThat(renegoFuture,is(not(sameInstance(clientHandshakeFuture))));
      assertThat(renegoFuture.isDone(),is(false));
    }
  }
  if (renegoFuture != null) {
    renegoFuture.sync();
  }
  if (serverHandler.renegoFuture != null) {
    serverHandler.renegoFuture.sync();
  }
  while (clientRecvCounter.get() < data.length) {
    if (serverException.get() != null) {
      break;
    }
    if (serverException.get() != null) {
      break;
    }
    try {
      Thread.sleep(50);
    }
 catch (    InterruptedException e) {
    }
  }
  while (serverRecvCounter.get() < data.length) {
    if (serverException.get() != null) {
      break;
    }
    if (clientException.get() != null) {
      break;
    }
    try {
      Thread.sleep(50);
    }
 catch (    InterruptedException e) {
    }
  }
  serverChannel.close().awaitUninterruptibly();
  clientChannel.close().awaitUninterruptibly();
  sc.close().awaitUninterruptibly();
  if (serverException.get() != null && !(serverException.get() instanceof IOException)) {
    throw serverException.get();
  }
  if (clientException.get() != null && !(clientException.get() instanceof IOException)) {
    throw clientException.get();
  }
  if (serverException.get() != null) {
    throw serverException.get();
  }
  if (clientException.get() != null) {
    throw clientException.get();
  }
  try {
    if (renegotiation.type != RenegotiationType.NONE) {
      assertThat(serverSslHandler.engine().getSession().getCipherSuite(),is(renegotiation.cipherSuite));
      assertThat(serverNegoCounter.get(),is(2));
      assertThat(clientSslHandler.engine().getSession().getCipherSuite(),is(renegotiation.cipherSuite));
      assertThat(clientNegoCounter.get(),is(2));
    }
 else {
      assertThat(serverNegoCounter.get(),is(1));
      assertThat(clientNegoCounter.get(),is(1));
    }
  }
 catch (  Throwable t) {
    TestUtils.dump(StringUtil.simpleClassName(this));
    throw t;
  }
 finally {
    logStats("STATS");
  }
}
