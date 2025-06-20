@Test public void jsonSerialized(){
  CastleMessage message=new CastleMessage("event");
  message.setCreatedAt("2018-01-01");
  message.setTimestamp("2018-01-01");
  message.setDeviceToken("1234");
  message.setReviewId("2345");
  message.setProperties(ImmutableMap.builder().put("key","val").build());
  message.setUserId("3456");
  message.setUserTraits(ImmutableMap.builder().put("key","val").build());
  String payloadJson=model.getGson().toJson(message);
  JsonParser parser=new JsonParser();
  String expected="{\"created_at\":\"2018-01-01\",\"timestamp\":\"2018-01-01\",\"device_token\":\"1234\",\"event\":\"event\",\"properties\":{\"key\":\"val\"},\"review_id\":\"2345\",\"user_id\":\"3456\",\"user_traits\":{\"key\":\"val\"}}";
  Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
}
