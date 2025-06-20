@Test public void assertIsLeaderUntilBlockWithoutLeaderAndAvailableServers(){
assertFalse(leaderService.isLeaderUntilBlock());
}