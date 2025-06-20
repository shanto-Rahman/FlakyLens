/** 
 * Test events related to signalling
 */
@Deployment public void testActivitySignalEvents() throws Exception {
assertNotNull(processInstance);
assertNotNull(executionWithSignal);
assertEquals(1,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiSignalEvent);
assertEquals(ActivitiEventType.ACTIVITY_SIGNALED,signalEvent.getType());
assertEquals("receivePayment",signalEvent.getActivityId());
assertEquals(executionWithSignal.getId(),signalEvent.getExecutionId());
assertEquals(executionWithSignal.getProcessInstanceId(),signalEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),signalEvent.getProcessDefinitionId());
assertNull(signalEvent.getSignalName());
assertNull(signalEvent.getSignalData());
assertEquals(1,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiSignalEvent);
assertEquals(ActivitiEventType.ACTIVITY_SIGNALED,signalEvent.getType());
assertEquals("shipOrder",signalEvent.getActivityId());
assertEquals(executionWithSignalEvent.getId(),signalEvent.getExecutionId());
assertEquals(executionWithSignalEvent.getProcessInstanceId(),signalEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),signalEvent.getProcessDefinitionId());
assertEquals("alert",signalEvent.getSignalName());
assertNotNull(signalEvent.getSignalData());
}