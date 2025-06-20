@Test public void timerTest() throws ExecutionException, InterruptedException {
assertNotNull("counting 5",observer.messagesReceived.poll(20,TimeUnit.SECONDS).getRight());
assertNotNull("counting 4",observer.messagesReceived.poll(2000,TimeUnit.SECONDS).getRight());
assertNotNull("counting 3",observer.messagesReceived.poll(5,TimeUnit.SECONDS).getRight());
assertNotNull("counting 2",observer.messagesReceived.poll(5,TimeUnit.SECONDS).getRight());
assertNotNull("counting 1",observer.messagesReceived.poll(5,TimeUnit.SECONDS).getRight());
assertTrue(System.currentTimeMillis() - start > 10);
assertNull(observer.messagesReceived.poll(10,TimeUnit.MILLISECONDS));
}