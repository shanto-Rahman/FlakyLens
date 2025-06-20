@Test(expected=ClusterStateException.class) public void testReassignFailOnStartNew() throws IOException {
assertSame(ClusterStateException.ClusterState.ROLLBACK_FAILED,rune.getClusterState());
assertSame(ClusterStateException.TransactionStep.START_NEW,rune.getTransactionStep());
}