public void testSslEcho(ServerBootstrap sb,Bootstrap cb) throws Throwable {
if (useChunkedWriteHandler) {
}
if (useChunkedWriteHandler) {
}
clientSendCounter.set(FIRST_MESSAGE_SIZE);
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
int clientSendCounterVal=clientSendCounter.get();
if (useCompositeByteBuf) {
}
clientSendCounter.set(clientSendCounterVal+=length);
if (needsRenegotiation && clientSendCounterVal >= data.length / 2) {
assertThat(renegoFuture,is(not(sameInstance(clientHandshakeFuture))));
assertThat(renegoFuture.isDone(),is(false));
}
if (renegoFuture != null) {
}
if (serverHandler.renegoFuture != null) {
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
 catch (  InterruptedException e) {
  }
}
if (serverException.get() != null) {
}
if (serverException.get() != null) {
}
Thread.sleep(50);
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
 catch (  InterruptedException e) {
  }
}
if (serverException.get() != null) {
}
if (clientException.get() != null) {
}
Thread.sleep(50);
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
if (renegotiation.type != RenegotiationType.NONE) {
assertThat(serverSslHandler.engine().getSession().getCipherSuite(),is(renegotiation.cipherSuite));
assertThat(serverNegoCounter.get(),is(2));
assertThat(clientSslHandler.engine().getSession().getCipherSuite(),is(renegotiation.cipherSuite));
assertThat(clientNegoCounter.get(),is(2));
assertThat(serverNegoCounter.get(),is(1));
assertThat(clientNegoCounter.get(),is(1));
}
}