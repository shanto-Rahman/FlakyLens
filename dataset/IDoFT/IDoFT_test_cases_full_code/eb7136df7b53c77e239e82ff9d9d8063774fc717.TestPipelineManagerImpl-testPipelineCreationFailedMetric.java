@Test public void testPipelineCreationFailedMetric() throws Exception {
  PipelineManagerImpl pipelineManager=createPipelineManager(true);
  MetricsRecordBuilder metrics=getMetrics(SCMPipelineMetrics.class.getSimpleName());
  long numPipelineAllocated=getLongCounter("NumPipelineAllocated",metrics);
  Assert.assertEquals(0,numPipelineAllocated);
  for (int i=0; i < maxPipelineCount; i++) {
    Pipeline pipeline=pipelineManager.createPipeline(new RatisReplicationConfig(ReplicationFactor.THREE));
    Assert.assertNotNull(pipeline);
  }
  metrics=getMetrics(SCMPipelineMetrics.class.getSimpleName());
  numPipelineAllocated=getLongCounter("NumPipelineAllocated",metrics);
  Assert.assertEquals(maxPipelineCount,numPipelineAllocated);
  long numPipelineCreateFailed=getLongCounter("NumPipelineCreationFailed",metrics);
  Assert.assertEquals(0,numPipelineCreateFailed);
  try {
    pipelineManager.createPipeline(new RatisReplicationConfig(ReplicationFactor.THREE));
    fail();
  }
 catch (  SCMException ioe) {
    Assert.assertEquals(SCMException.ResultCodes.FAILED_TO_FIND_SUITABLE_NODE,ioe.getResult());
  }
  metrics=getMetrics(SCMPipelineMetrics.class.getSimpleName());
  numPipelineAllocated=getLongCounter("NumPipelineAllocated",metrics);
  Assert.assertEquals(maxPipelineCount,numPipelineAllocated);
  numPipelineCreateFailed=getLongCounter("NumPipelineCreationFailed",metrics);
  Assert.assertEquals(1,numPipelineCreateFailed);
  pipelineManager.close();
}
