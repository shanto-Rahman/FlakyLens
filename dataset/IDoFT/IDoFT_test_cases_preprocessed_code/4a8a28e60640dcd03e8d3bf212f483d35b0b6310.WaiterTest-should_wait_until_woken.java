@Test public void should_wait_until_woken() throws ExecutionException, InterruptedException {
Future<Long> waitTime=executor.submit(new WaitForWaiter(waiter));
assertTrue("Waited: " + waitTime.get(),waitTime.get() < 100L);
Future<Long> waitTime2=executor.submit(new WaitForWaiter(waiter));
assertTrue("Waited: " + waitTime2.get(),waitTime2.get() < 100L);
}