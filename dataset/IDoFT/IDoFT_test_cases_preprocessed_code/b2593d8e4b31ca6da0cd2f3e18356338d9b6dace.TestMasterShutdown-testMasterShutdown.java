/** 
 * Simple test of shutdown. <p> Starts with three masters. Tells the active master to shutdown the cluster. Verifies that all masters are properly shutdown.
 * @throws Exception
 */
@Test(timeout=240000) public void testMasterShutdown() throws Exception {
assertTrue(mt.isAlive());
if (masterThreads.get(i).getMaster().isActiveMaster()) {
}
assertNotNull(active);
assertEquals(2,status.getBackupMastersSize());
assertEquals(2,status.getBackupMasters().size());
assertEquals(0,masterThreads.size());
}