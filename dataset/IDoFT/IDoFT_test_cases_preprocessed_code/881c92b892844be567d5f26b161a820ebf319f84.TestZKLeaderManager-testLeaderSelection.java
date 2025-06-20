@Test public void testLeaderSelection() throws Exception {
assertNotNull("Leader should exist",currentLeader);
LOG.debug("Current leader index is " + currentLeader.getIndex());//IT
assertNotNull("Leader znode should contain leader index",znodeData);
assertTrue("Leader znode should not be empty",znodeData.length > 0);
assertEquals("Leader znode should match leader index",currentLeader.getIndex(),storedIndex);//IT
currentLeader.abdicate();//IT
assertNotNull("New leader should exist after abdication",currentLeader);
LOG.debug("New leader index is " + currentLeader.getIndex());//IT
assertNotNull("Leader znode should contain leader index",znodeData);
assertTrue("Leader znode should not be empty",znodeData.length > 0);
assertEquals("Leader znode should match leader index",currentLeader.getIndex(),storedIndex);//IT
currentLeader.stop("Stopping for test");//IT
assertNotNull("New leader should exist after stop",currentLeader);
LOG.debug("New leader index is " + currentLeader.getIndex());//IT
assertNotNull("Leader znode should contain leader index",znodeData);
assertTrue("Leader znode should not be empty",znodeData.length > 0);
assertEquals("Leader znode should match leader index",currentLeader.getIndex(),storedIndex);//IT
currentLeader.stop("Stopping for test");//IT
assertNotNull("New leader should exist",currentLeader);
}