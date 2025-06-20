@Test public void testGetPrediction(){
Assert.assertEquals("null",response);
Assert.assertEquals(1,skylineList.getCapacityAtTime(0).getMemorySize() / containerMemAlloc);
Assert.assertEquals(1058,skylineList.getCapacityAtTime(10).getMemorySize() / containerMemAlloc);
Assert.assertEquals(2538,skylineList.getCapacityAtTime(15).getMemorySize() / containerMemAlloc);
Assert.assertEquals(2484,skylineList.getCapacityAtTime(20).getMemorySize() / containerMemAlloc);
Assert.assertEquals(1,jobHistory.size());
Assert.assertEquals("tpch_q12_0",pipelineId);
}