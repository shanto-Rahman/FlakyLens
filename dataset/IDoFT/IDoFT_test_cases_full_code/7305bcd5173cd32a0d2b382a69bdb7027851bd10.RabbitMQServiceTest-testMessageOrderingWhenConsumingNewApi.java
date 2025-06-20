@Test public void testMessageOrderingWhenConsumingNewApi(TestContext ctx) throws IOException {
  String queueName=randomAlphaString(10);
  String address=queueName + ".address";
  int count=1000;
  List<String> sendingOrder=IntStream.range(1,count).boxed().map(Object::toString).collect(Collectors.toList());
  AMQP.Queue.DeclareOk ok=channel.queueDeclare(queueName,false,false,true,null);
  ctx.assertNotNull(ok.getQueue());
  AMQP.BasicProperties properties=new AMQP.BasicProperties.Builder().contentType("text/plain").contentEncoding("UTF-8").build();
  for (  String msg : sendingOrder)   channel.basicPublish("",queueName,properties,msg.getBytes("UTF-8"));
  List<String> receivedOrder=Collections.synchronizedList(new ArrayList<>());
  Async async=ctx.async(sendingOrder.size());
  client.basicConsumer(queueName,consumerHandler -> {
    if (consumerHandler.succeeded()) {
      consumerHandler.result().handler(msg -> {
        ctx.assertNotNull(msg);
        String body=msg.body().toString();
        ctx.assertNotNull(body);
        receivedOrder.add(body);
        async.countDown();
      }
);
    }
 else {
      ctx.fail();
    }
  }
);
  async.awaitSuccess(15000);
  for (int i=0; i < sendingOrder.size(); i++) {
    ctx.assertTrue(sendingOrder.get(i).equals(receivedOrder.get(i)));
  }
}
