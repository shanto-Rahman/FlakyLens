/** 
 * Tests that an exception is thrown when a session tries to acquire a write lock on a block that it currently has a write lock on.
 */
@Test public void lockAlreadyWriteLockedBlock(){
  BlockLockManager manager=new BlockLockManager();
  manager.lockBlock(1,1,BlockLockType.WRITE);
  mThrown.expect(IllegalStateException.class);
  manager.lockBlock(1,1,BlockLockType.WRITE);
}
