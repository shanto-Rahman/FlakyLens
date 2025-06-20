@Test public void keepMostRecentOptionShouldWorks(TestContext ctx) throws Exception {
  int count=2;
  int queueSize=1;
  Set<String> messages=createMessages(count);
  Iterator<String> iterator=messages.iterator();
  iterator.next();
  String secondMessage=iterator.next();
  String q=setupQueue(ctx,messages);
  Async paused=ctx.async();
  Async secondReceived=ctx.async();
  AtomicReference<RabbitMQConsumer> mqConsumer=new AtomicReference<>(null);
  QueueOptions queueOptions=new QueueOptions().setKeepMostRecent(true).setMaxInternalQueueSize(queueSize);
  client.basicConsumer(q,queueOptions,ctx.asyncAssertSuccess(consumer -> {
    mqConsumer.set(consumer);
    consumer.pause();
    consumer.handler(msg -> {
      ctx.assertTrue(msg.body().toString().equals(secondMessage),"only second message should be stored");
      secondReceived.complete();
    }
);
    paused.complete();
  }
));
  paused.awaitSuccess(15000);
  Async done=ctx.async();
  vertx.setTimer(1000,l -> {
    mqConsumer.get().resume();
    vertx.setTimer(1000,t -> done.complete());
  }
);
}
