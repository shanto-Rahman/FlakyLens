@Deployment public void testGetBpmnModel(){
assertNotNull(bpmnModel);
assertEquals(1,bpmnModel.getProcesses().size());
assertTrue(!bpmnModel.getLocationMap().isEmpty());
assertTrue(!bpmnModel.getFlowLocationMap().isEmpty());
assertEquals(1,startEvents.size());
assertEquals(1,startEvent.getOutgoingFlows().size());
assertEquals(0,startEvent.getIncomingFlows().size());
assertEquals("First Task",userTask.getName());
assertEquals(1,userTask.getOutgoingFlows().size());
assertEquals(1,userTask.getIncomingFlows().size());
assertEquals(2,parallelGateway.getOutgoingFlows().size());
assertEquals(1,parallelGateway.getIncomingFlows().size());
assertEquals(1,userTask.getOutgoingFlows().size());
assertEquals(1,parallelGateway.getOutgoingFlows().size());
assertEquals(2,parallelGateway.getIncomingFlows().size());
assertEquals(0,endEvent.getOutgoingFlows().size());
assertEquals(1,endEvent.getIncomingFlows().size());
}