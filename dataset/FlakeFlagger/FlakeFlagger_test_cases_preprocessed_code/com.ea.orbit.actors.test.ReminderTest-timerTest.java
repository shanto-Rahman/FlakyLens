@Test public void timerTest() throws ExecutionException, InterruptedException {
assertEquals("bla",remindersReceived.poll(5,TimeUnit.SECONDS));//RW
assertEquals("bla",remindersReceived.poll(5,TimeUnit.SECONDS));//RW
}