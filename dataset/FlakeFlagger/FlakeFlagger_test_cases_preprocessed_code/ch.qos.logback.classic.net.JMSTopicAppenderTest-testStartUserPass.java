@Test public void testStartUserPass(){
assertTrue(appender.isStarted());
assertEquals(appender.topicBindingName,appender.topicPublisher.getTopic().getTopicName());
fail();
}