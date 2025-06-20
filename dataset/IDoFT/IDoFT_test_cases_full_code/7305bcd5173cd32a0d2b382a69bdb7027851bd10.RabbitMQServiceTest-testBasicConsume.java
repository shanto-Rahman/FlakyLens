@Test public void testBasicConsume(TestContext ctx) throws Exception {
  int count=3;
  Set<String> messages=createMessages(count);
  String q=setupQueue(ctx,messages);
  Async latch=ctx.async(count);
  vertx.eventBus().consumer("my.address",msg -> {
    JsonObject json=(JsonObject)msg.body();
    ctx.assertNotNull(json);
    String body=json.getString("body");
    ctx.assertNotNull(body);
    ctx.assertTrue(messages.contains(body));
    latch.countDown();
  }
);
  client.basicConsume(q,"my.address",ctx.asyncAssertSuccess(v -> {
  }
));
}
