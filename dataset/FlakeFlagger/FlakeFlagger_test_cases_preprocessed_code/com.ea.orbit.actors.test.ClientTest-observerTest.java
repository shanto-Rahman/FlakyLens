@Test public void observerTest() throws ExecutionException, InterruptedException {
assertEquals("bla",observer1.messagesReceived.poll(5,TimeUnit.SECONDS).getRight());
assertEquals("bla",observer2.messagesReceived.poll(5,TimeUnit.SECONDS).getRight());
}