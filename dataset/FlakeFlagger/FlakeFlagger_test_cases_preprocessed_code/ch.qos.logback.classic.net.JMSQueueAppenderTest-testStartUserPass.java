public void testStartUserPass(){
assertTrue(appender.isStarted());
assertEquals(appender.queueBindingName,appender.queueSender.getQueue().getQueueName());
fail();
}