@Test public void testBasicCancel(TestContext ctx) throws Exception {
  int count=3;
  Set<String> messages=createMessages(count);
  String q=setupQueue(ctx,messages);
  Async async=ctx.async();
  AtomicInteger received=new AtomicInteger(0);
  vertx.eventBus().consumer("my.address",msg -> {
    int receivedTotal=received.incrementAndGet();
    log.info(String.format("received %d-th message",receivedTotal));
    ctx.assertFalse(receivedTotal > count);
    if (receivedTotal == 3) {
      vertx.setTimer(1000,id -> {
        async.complete();
      }
);
    }
  }
);
  client.basicConsume(q,"my.address",ctx.asyncAssertSuccess(tag -> {
    client.basicCancel(tag);
    String body=randomAlphaString(100);
    JsonObject message=new JsonObject().put("body",body);
    client.basicPublish("",q,message,null);
  }
));
}
