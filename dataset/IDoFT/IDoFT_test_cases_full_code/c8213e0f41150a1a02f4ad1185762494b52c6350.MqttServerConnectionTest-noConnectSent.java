@Test public void noConnectSent(TestContext context){
  NetClient client=this.vertx.createNetClient();
  Async async=context.async();
  client.connect(MQTT_SERVER_PORT,MQTT_SERVER_HOST,done -> {
    if (done.succeeded()) {
      done.result().closeHandler(v -> {
        log.info("No CONNECT sent in " + MQTT_TIMEOUT_ON_CONNECT + " secs. Closing connection.");
        async.complete();
      }
);
    }
 else {
      context.fail();
    }
  }
);
  async.await(500 + MQTT_TIMEOUT_ON_CONNECT * 1000);
  if (!async.isCompleted())   context.fail();
}
