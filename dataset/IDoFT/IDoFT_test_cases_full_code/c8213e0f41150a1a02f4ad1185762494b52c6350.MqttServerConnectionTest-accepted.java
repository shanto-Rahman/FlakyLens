@Test public void accepted(TestContext context){
  this.expectedReturnCode=MqttConnectReturnCode.CONNECTION_ACCEPTED;
  try {
    MemoryPersistence persistence=new MemoryPersistence();
    MqttClient client=new MqttClient(String.format("tcp://%s:%d",MQTT_SERVER_HOST,MQTT_SERVER_PORT),"12345",persistence);
    client.connect();
  }
 catch (  MqttException e) {
    context.fail(e);
  }
}
