/** 
 * Test that we can interrupt a node that is blocked on a wait.
 */
@Test public void testInterruptible() throws IOException, InterruptedException {
  Abortable abortable=new StubAbortable();
  ZKWatcher zk=new ZKWatcher(TEST_UTIL.getConfiguration(),"testInterruptible",abortable);
  final TestTracker tracker=new TestTracker(zk,"/xyz",abortable);
  tracker.start();
  Thread t=new Thread(() -> {
    try {
      tracker.blockUntilAvailable();
    }
 catch (    InterruptedException e) {
      throw new RuntimeException("Interrupted",e);
    }
  }
);
  t.start();
  while (!t.isAlive()) {
    Threads.sleep(1);
  }
  tracker.stop();
  t.join();
}
