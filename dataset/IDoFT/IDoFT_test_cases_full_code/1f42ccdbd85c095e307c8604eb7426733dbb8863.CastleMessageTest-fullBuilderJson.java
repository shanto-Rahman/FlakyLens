@Test public void fullBuilderJson(){
  CastleMessage message=CastleMessage.builder("event").createdAt("2018-01-01").timestamp("2018-01-01").deviceToken("1234").reviewId("2345").properties(ImmutableMap.builder().put("key","val").build()).userId("3456").userTraits(ImmutableMap.builder().put("key","val").build()).build();
  Assert.assertEquals(message.getCreatedAt(),"2018-01-01");
  Assert.assertEquals(message.getDeviceToken(),"1234");
  Assert.assertEquals(message.getReviewId(),"2345");
  Assert.assertEquals(message.getUserId(),"3456");
  Assert.assertEquals(message.getEvent(),"event");
  Assert.assertEquals(message.getUserTraits(),ImmutableMap.builder().put("key","val").build());
  Assert.assertEquals(message.getProperties(),ImmutableMap.builder().put("key","val").build());
  String payloadJson=model.getGson().toJson(message);
  Assertions.assertThat(payloadJson).isEqualTo("{\"created_at\":\"2018-01-01\",\"timestamp\":\"2018-01-01\",\"device_token\":\"1234\",\"event\":\"event\",\"properties\":{\"key\":\"val\"},\"review_id\":\"2345\",\"user_id\":\"3456\",\"user_traits\":{\"key\":\"val\"}}");
}
