@Test public void testGetPrediction(){
  final String logFile="resourceEstimatorService.txt";
  WebResource webResource=resource();
  webResource.path(parseLogCommand).type(MediaType.APPLICATION_XML_TYPE).post(logFile);
  webResource=resource().path(getHistorySkylineCommand);
  String response=webResource.get(String.class);
  Map<RecurrenceId,List<ResourceSkyline>> jobHistory=gson.fromJson(response,new TypeToken<Map<RecurrenceId,List<ResourceSkyline>>>(){
  }
.getType());
  checkResult("tpch_q12_0",jobHistory);
  checkResult("tpch_q12_1",jobHistory);
  webResource=resource().path(getEstimatedSkylineCommand);
  response=webResource.get(String.class);
  Assert.assertEquals("null",response);
  webResource=resource().path(makeEstimationCommand);
  response=webResource.get(String.class);
  RLESparseResourceAllocation skylineList=gson.fromJson(response,new TypeToken<RLESparseResourceAllocation>(){
  }
.getType());
  Assert.assertEquals(1,skylineList.getCapacityAtTime(0).getMemorySize() / containerMemAlloc);
  Assert.assertEquals(1058,skylineList.getCapacityAtTime(10).getMemorySize() / containerMemAlloc);
  Assert.assertEquals(2538,skylineList.getCapacityAtTime(15).getMemorySize() / containerMemAlloc);
  Assert.assertEquals(2484,skylineList.getCapacityAtTime(20).getMemorySize() / containerMemAlloc);
  webResource=resource().path(getEstimatedSkylineCommand);
  response=webResource.get(String.class);
  final RLESparseResourceAllocation skylineList2=gson.fromJson(response,new TypeToken<RLESparseResourceAllocation>(){
  }
.getType());
  compareRLESparseResourceAllocation(skylineList,skylineList2);
  webResource=resource().path(makeEstimationCommand);
  response=webResource.get(String.class);
  final RLESparseResourceAllocation skylineList3=gson.fromJson(response,new TypeToken<RLESparseResourceAllocation>(){
  }
.getType());
  compareRLESparseResourceAllocation(skylineList,skylineList3);
  webResource=resource().path(deleteHistoryCommand);
  webResource.delete();
  webResource=resource().path(getHistorySkylineCommand);
  response=webResource.get(String.class);
  jobHistory=gson.fromJson(response,new TypeToken<Map<RecurrenceId,List<ResourceSkyline>>>(){
  }
.getType());
  Assert.assertEquals(1,jobHistory.size());
  final String pipelineId=((RecurrenceId)jobHistory.keySet().toArray()[0]).getRunId();
  Assert.assertEquals("tpch_q12_0",pipelineId);
}
