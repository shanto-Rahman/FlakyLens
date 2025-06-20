@Test public void testSuccessTimeFailureExcluded() throws Exception {
  measuredReplicator.replicate(new ReplicationTask(300L,new ArrayList<>()));
  Assert.assertEquals(0,measuredReplicator.getSuccessTime().value());
}
