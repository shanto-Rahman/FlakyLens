@Test public void measureFailureSuccessAndBytes() throws Exception {
  measuredReplicator.replicate(new ReplicationTask(1L,new ArrayList<>()));
  measuredReplicator.replicate(new ReplicationTask(2L,new ArrayList<>()));
  measuredReplicator.replicate(new ReplicationTask(3L,new ArrayList<>()));
  Assert.assertEquals(2,measuredReplicator.getSuccess().value());
  Assert.assertEquals(1,measuredReplicator.getFailure().value());
  Assert.assertEquals(4 * 1024,measuredReplicator.getTransferredBytes().value());
}
