@Test public void fullBuilderJson(){
Assert.assertEquals(message.getCreatedAt(),"2018-01-01");
Assert.assertEquals(message.getDeviceToken(),"1234");
Assert.assertEquals(message.getReviewId(),"2345");
Assert.assertEquals(message.getUserId(),"3456");
Assert.assertEquals(message.getEvent(),"event");
Assert.assertEquals(message.getUserTraits(),ImmutableMap.builder().put("key","val").build());
Assert.assertEquals(message.getProperties(),ImmutableMap.builder().put("key","val").build());
Assertions.assertThat(parser.parse(payloadJson)).isEqualTo(parser.parse(expected));
}