@Test public void testOnLeaderElectionCompletion() throws Exception {
  leaderElectionMetrics.onNewLeaderElectionCompletion();
  Long leaderElectionLatency=(Long)ratisMetricRegistry.getGauges((s,metric) -> s.contains(LAST_LEADER_ELECTION_ELAPSED_TIME)).values().iterator().next().getValue();
  assertTrue(leaderElectionLatency > 0L);
}
