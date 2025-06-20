/** 
 * Test that when a thread tries to obtain a read lock when another thread holds a write lock, fails to acquire the lock, if the write lock is not released within the timeout specified
 * @throws Exception
 */
@Test public void testTimeout() throws Exception {
threadHoldingWriteLock.start();
Thread.sleep(500);
boolean readLockAcquired=readLock.tryLock(2,TimeUnit.SECONDS);
Assert.assertFalse("Unexpected obtained a read lock",readLockAcquired);
latch.countDown();
latch.await();
}