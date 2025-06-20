@Test public void testPublish_Object() throws IOException {
assertThat(message.getData().toStringUtf8()).isEqualTo("{\"@class\":" + "\"com.google.cloud.spring.pubsub.core.test.allowed.AllowedPayload\"" + ",\"name\":\"allowed\",\"value\":12345}");
}