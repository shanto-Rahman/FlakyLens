@Test public void testPublish_Object() throws IOException {
  AllowedPayload allowedPayload=new AllowedPayload();
  allowedPayload.name="allowed";
  allowedPayload.value=12345;
  PubSubPublisherTemplate pubSubPublisherTemplate=spy(createPublisherTemplate());
  doAnswer(invocation -> {
    PubsubMessage message=invocation.getArgument(1);
    assertThat(message.getData().toStringUtf8()).isEqualTo("{\"@class\":" + "\"com.google.cloud.spring.pubsub.core.test.allowed.AllowedPayload\"" + ",\"name\":\"allowed\",\"value\":12345}");
    return null;
  }
).when(pubSubPublisherTemplate).publish(eq("test"),any());
  pubSubPublisherTemplate.publish("test",allowedPayload);
  verify(pubSubPublisherTemplate,times(1)).publish(eq("test"),isA(PubsubMessage.class));
}
