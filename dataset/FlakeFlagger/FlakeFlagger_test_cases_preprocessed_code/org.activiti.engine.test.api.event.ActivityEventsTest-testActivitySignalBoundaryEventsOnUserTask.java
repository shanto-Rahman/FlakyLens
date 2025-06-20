@Deployment public void testActivitySignalBoundaryEventsOnUserTask() throws Exception {
assertNotNull(processInstance);
assertNotNull(executionWithSignal);
assertEquals(2,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiSignalEventImpl);
assertEquals(ActivitiEventType.ACTIVITY_SIGNALED,signalEvent.getType());
assertEquals("boundarySignalEventCatching",signalEvent.getActivityId());
assertEquals(executionWithSignal.getProcessInstanceId(),signalEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),signalEvent.getProcessDefinitionId());
assertTrue(listener.getEventsReceived().get(1) instanceof ActivitiActivityCancelledEvent);
assertEquals(ActivitiEventType.ACTIVITY_CANCELLED,cancelEvent.getType());
assertEquals("userTask",cancelEvent.getActivityId());
assertEquals(executionWithSignal.getProcessInstanceId(),cancelEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),cancelEvent.getProcessDefinitionId());
assertNotNull(cancelEvent.getCause());
assertTrue(cancelEvent.getCause() instanceof SignalEventSubscriptionEntity);
assertEquals("signalName",cause.getEventName());
}