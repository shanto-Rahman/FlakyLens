@Test public void persistedTimerTest() throws ExecutionException, InterruptedException {
assertEquals("bla",remindersReceived.poll(5,TimeUnit.SECONDS));//RW
remindersReceived.clear();//RW
assertNull(remindersReceived.poll(5,TimeUnit.MILLISECONDS));//RW
assertEquals("bla",remindersReceived.poll(5,TimeUnit.SECONDS));//RW
}