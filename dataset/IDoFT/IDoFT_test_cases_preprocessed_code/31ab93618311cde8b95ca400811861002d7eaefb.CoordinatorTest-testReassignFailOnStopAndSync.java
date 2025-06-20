@Test(expected=ClusterStateException.class) public void testReassignFailOnStopAndSync() throws IOException {
assertSame(ClusterStateException.ClusterState.ROLLBACK_FAILED,rune.getClusterState());
assertSame(ClusterStateException.TransactionStep.STOP_AND_SNYC,rune.getTransactionStep());
}