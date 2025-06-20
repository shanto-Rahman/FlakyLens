/** 
 * Test that LogbackMDCAdapter copies its hashmap when a child thread inherits it.
 * @throws InterruptedException
 */
@Test public void copyOnInheritenceTest() throws InterruptedException {
childThread.start();
countDownLatch.await();
childThread.join();
assertNull(mdcAdapter.get(secondKey));
assertTrue(childThread.successful);
assertTrue(parentHM != childThread.childHM);
assertEquals(parentHMWitness,parentHM);
assertEquals(childHMWitness,childThread.childHM);
}