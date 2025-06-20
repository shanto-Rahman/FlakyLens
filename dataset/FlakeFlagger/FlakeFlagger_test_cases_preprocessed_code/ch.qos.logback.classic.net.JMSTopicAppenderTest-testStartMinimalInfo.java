@Test public void testStartMinimalInfo(){
assertTrue(appender.isStarted());
assertEquals(appender.topicBindingName,appender.topicPublisher.getTopic().getTopicName());
fail();
}