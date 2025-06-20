@Test public void unsubscribe(TestContext context){
  this.subscribeAsync=context.async();
  this.unsubscribeAsync=context.async();
  try {
    MemoryPersistence persistence=new MemoryPersistence();
    MqttClient client=new MqttClient(String.format("tcp://%s:%d",MQTT_SERVER_HOST,MQTT_SERVER_PORT),"12345",persistence);
    client.connect();
    String[] topics=new String[]{MQTT_TOPIC};
    int[] qos=new int[]{0};
    client.subscribe(topics,qos);
    this.subscribeAsync.await();
    client.unsubscribe(topics);
    this.unsubscribeAsync.await();
    context.assertTrue(true);
  }
 catch (  MqttException e) {
    context.assertTrue(false);
    e.printStackTrace();
  }
}
