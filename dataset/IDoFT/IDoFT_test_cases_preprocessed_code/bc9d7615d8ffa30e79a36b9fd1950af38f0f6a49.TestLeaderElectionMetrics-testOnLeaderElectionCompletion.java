@Test public void testOnLeaderElectionCompletion() throws Exception {
leaderElectionMetrics.onNewLeaderElectionCompletion();//RW
Long leaderElectionLatency=(Long)ratisMetricRegistry.getGauges((s,metric) -> s.contains(LAST_LEADER_ELECTION_ELAPSED_TIME)).values().iterator().next().getValue();//RW
assertTrue(leaderElectionLatency > 0L);
}