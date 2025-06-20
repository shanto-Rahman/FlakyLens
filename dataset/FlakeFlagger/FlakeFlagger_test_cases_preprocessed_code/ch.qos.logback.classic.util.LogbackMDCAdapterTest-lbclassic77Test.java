/** 
 * Test that CopyOnInheritThreadLocal does not barf when the MDC hashmap is null
 * @throws InterruptedException
 */
@Test public void lbclassic77Test() throws InterruptedException {
assertNull(parentHM);
childThread.start();
childThread.join();
assertTrue(childThread.successul);
assertNull(childThread.childHM);
}