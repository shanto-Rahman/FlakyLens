@Test public void testGetMessageCount(TestContext ctx) throws Exception {
  int count=3;
  Set<String> messages=createMessages(count);
  String queue=setupQueue(ctx,messages);
  Async async=ctx.async();
  vertx.setTimer(2000,t -> client.messageCount(queue,ctx.asyncAssertSuccess(messageCount -> {
    ctx.assertEquals(count,messageCount.intValue());
    client.queueDelete(queue,ctx.asyncAssertSuccess(json -> async.complete()));
  }
)));
}
