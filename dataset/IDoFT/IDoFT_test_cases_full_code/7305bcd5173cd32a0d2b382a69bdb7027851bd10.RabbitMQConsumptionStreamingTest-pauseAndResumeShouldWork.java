@Test public void pauseAndResumeShouldWork(TestContext ctx) throws Exception {
  int count=1;
  Set<String> messages=createMessages(count);
  String q=setupQueue(ctx,messages);
  Async paused=ctx.async();
  Async resumed=ctx.async();
  Async messageReceived=ctx.async();
  client.basicConsumer(q,new QueueOptions(),ctx.asyncAssertSuccess(consumer -> {
    consumer.pause();
    consumer.handler(msg -> {
      ctx.assertNotNull(msg);
      if (resumed.count() == 1) {
        ctx.fail();
      }
 else {
        messageReceived.complete();
      }
    }
);
    paused.complete();
    resumed.await();
    consumer.resume();
  }
));
  paused.awaitSuccess(15000);
  vertx.setTimer(1000,t -> resumed.complete());
}
