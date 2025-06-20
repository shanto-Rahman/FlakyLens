@Test public void testSuccessTime() throws Exception {
  measuredReplicator.replicate(new ReplicationTask(101L,new ArrayList<>()));
  measuredReplicator.replicate(new ReplicationTask(201L,new ArrayList<>()));
  measuredReplicator.replicate(new ReplicationTask(300L,new ArrayList<>()));
  Assert.assertTrue("Measured time should be at least 300 ms but was " + measuredReplicator.getSuccessTime().value(),measuredReplicator.getSuccessTime().value() >= 300L);
}
