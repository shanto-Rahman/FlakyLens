/** 
 * Test that we can interrupt a node that is blocked on a wait.
 */
@Test public void testInterruptible() throws IOException, InterruptedException {
t.start();
while (!t.isAlive()) {
  Threads.sleep(1);
}
t.join();
}