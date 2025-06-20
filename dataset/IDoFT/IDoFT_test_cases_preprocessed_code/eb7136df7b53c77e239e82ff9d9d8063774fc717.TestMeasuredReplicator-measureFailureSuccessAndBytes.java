@Test public void measureFailureSuccessAndBytes() throws Exception {
Assert.assertEquals(2,measuredReplicator.getSuccess().value());
Assert.assertEquals(1,measuredReplicator.getFailure().value());
Assert.assertEquals(4 * 1024,measuredReplicator.getTransferredBytes().value());
}