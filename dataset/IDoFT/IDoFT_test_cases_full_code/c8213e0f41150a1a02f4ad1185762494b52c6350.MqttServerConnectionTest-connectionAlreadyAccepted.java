@Test public void connectionAlreadyAccepted(TestContext context) throws Exception {
  this.expectedReturnCode=MqttConnectReturnCode.CONNECTION_ACCEPTED;
  MemoryPersistence persistence=new MemoryPersistence();
  MqttClient client=new MqttClient(String.format("tcp://%s:%d",MQTT_SERVER_HOST,MQTT_SERVER_PORT),"12345",persistence);
  client.connect();
  try {
    this.endpoint.accept(false);
    context.fail();
  }
 catch (  IllegalStateException e) {
  }
}
