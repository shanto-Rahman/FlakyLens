/** 
 * Test that a    {@link javax.ejb.IllegalLoopbackException}  is thrown when the thread owning a read locktries to obtain a write lock
 * @throws Exception
 */
@Test public void testIllegalLoopBack() throws Exception {
readLock.lock();
writeLock.lock();
writeLock.unlock();
Assert.fail("Unexpected acquired write lock");
readLock.unlock();
}