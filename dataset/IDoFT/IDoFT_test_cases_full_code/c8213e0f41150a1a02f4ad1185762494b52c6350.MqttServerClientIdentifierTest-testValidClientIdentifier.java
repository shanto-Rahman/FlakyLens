@Test public void testValidClientIdentifier(TestContext context) throws Exception {
  MemoryPersistence persistence=new MemoryPersistence();
  MqttClient client=new MqttClient(String.format("tcp://%s:%d",MQTT_SERVER_HOST,MQTT_SERVER_PORT),"id-madeof-23-characters",persistence);
  MqttConnectOptions options=new MqttConnectOptions();
  options.setMqttVersion(MQTT_VERSION_3_1);
  try {
    client.connect(options);
    context.assertTrue(true);
  }
 catch (  MqttException ignore) {
    context.assertTrue(false);
  }
}
