/** 
 * Test events related to message events, called from the API.
 */
@Deployment public void testActivityMessageBoundaryEventsOnSubProcess() throws Exception {
assertNotNull(processInstance);
assertNotNull(executionWithMessage);
assertEquals(4,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiMessageEvent);
assertEquals(ActivitiEventType.ACTIVITY_MESSAGE_WAITING,messageEvent.getType());
assertEquals("boundaryMessageEventCatching",messageEvent.getActivityId());
assertEquals(executionWithMessage.getId(),messageEvent.getExecutionId());
assertEquals(executionWithMessage.getProcessInstanceId(),messageEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),messageEvent.getProcessDefinitionId());
assertEquals("message_1",messageEvent.getMessageName());
assertNull(messageEvent.getMessageData());
assertTrue(listener.getEventsReceived().get(1) instanceof ActivitiMessageEvent);
assertEquals(ActivitiEventType.ACTIVITY_MESSAGE_RECEIVED,messageEvent.getType());
assertEquals("boundaryMessageEventCatching",messageEvent.getActivityId());
assertEquals(executionWithMessage.getId(),messageEvent.getExecutionId());
assertEquals(executionWithMessage.getProcessInstanceId(),messageEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),messageEvent.getProcessDefinitionId());
assertEquals("message_1",messageEvent.getMessageName());
assertNull(messageEvent.getMessageData());
assertTrue(listener.getEventsReceived().get(2) instanceof ActivitiActivityCancelledEvent);
assertEquals(ActivitiEventType.ACTIVITY_CANCELLED,signalEvent.getType());
assertEquals("subProcess",signalEvent.getActivityId());
assertEquals(executionWithMessage.getProcessInstanceId(),signalEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),signalEvent.getProcessDefinitionId());
assertNotNull(signalEvent.getCause());
assertTrue(signalEvent.getCause() instanceof MessageEventSubscriptionEntity);
assertEquals("message_1",cause.getEventName());
assertTrue(listener.getEventsReceived().get(3) instanceof ActivitiActivityCancelledEvent);
assertEquals(ActivitiEventType.ACTIVITY_CANCELLED,signalEvent.getType());
assertEquals("cloudformtask1",signalEvent.getActivityId());
assertEquals(executionWithMessage.getProcessInstanceId(),signalEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),signalEvent.getProcessDefinitionId());
assertNotNull(signalEvent.getCause());
assertTrue(signalEvent.getCause() instanceof MessageEventSubscriptionEntity);
assertEquals("message_1",cause.getEventName());
}