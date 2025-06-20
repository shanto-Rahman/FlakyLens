@Test public void testPipelineCreationFailedMetric() throws Exception {
Assert.assertEquals(0,numPipelineAllocated);
Assert.assertNotNull(pipeline);
Assert.assertEquals(maxPipelineCount,numPipelineAllocated);
Assert.assertEquals(0,numPipelineCreateFailed);
fail();
Assert.assertEquals(SCMException.ResultCodes.FAILED_TO_FIND_SUITABLE_NODE,ioe.getResult());
Assert.assertEquals(maxPipelineCount,numPipelineAllocated);
Assert.assertEquals(1,numPipelineCreateFailed);
}