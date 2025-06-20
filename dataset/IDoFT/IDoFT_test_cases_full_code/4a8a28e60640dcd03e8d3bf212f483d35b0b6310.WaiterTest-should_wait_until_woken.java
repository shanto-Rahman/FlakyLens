@Test public void should_wait_until_woken() throws ExecutionException, InterruptedException {
  Waiter waiter=new Waiter(Duration.ofMillis(1000));
  Future<Long> waitTime=executor.submit(new WaitForWaiter(waiter));
  sleep(20);
  waiter.wake();
  assertTrue("Waited: " + waitTime.get(),waitTime.get() < 100L);
  Future<Long> waitTime2=executor.submit(new WaitForWaiter(waiter));
  sleep(20);
  waiter.wake();
  assertTrue("Waited: " + waitTime2.get(),waitTime2.get() < 100L);
}
