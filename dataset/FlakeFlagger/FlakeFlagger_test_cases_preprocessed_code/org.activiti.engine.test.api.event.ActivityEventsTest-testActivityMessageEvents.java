/** 
 * Test events related to message events, called from the API.
 */
@Deployment public void testActivityMessageEvents() throws Exception {
assertNotNull(processInstance);
assertNotNull(executionWithMessage);
assertEquals(2,listener.getEventsReceived().size());
assertTrue(listener.getEventsReceived().get(0) instanceof ActivitiMessageEvent);
assertEquals(ActivitiEventType.ACTIVITY_MESSAGE_WAITING,messageEvent.getType());
assertEquals("shipOrder",messageEvent.getActivityId());
assertEquals(executionWithMessage.getId(),messageEvent.getExecutionId());
assertEquals(executionWithMessage.getProcessInstanceId(),messageEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),messageEvent.getProcessDefinitionId());
assertEquals("messageName",messageEvent.getMessageName());
assertNull(messageEvent.getMessageData());
assertTrue(listener.getEventsReceived().get(1) instanceof ActivitiMessageEvent);
assertEquals(ActivitiEventType.ACTIVITY_MESSAGE_RECEIVED,messageEvent.getType());
assertEquals("shipOrder",messageEvent.getActivityId());
assertEquals(executionWithMessage.getId(),messageEvent.getExecutionId());
assertEquals(executionWithMessage.getProcessInstanceId(),messageEvent.getProcessInstanceId());
assertEquals(processInstance.getProcessDefinitionId(),messageEvent.getProcessDefinitionId());
assertEquals("messageName",messageEvent.getMessageName());
assertNull(messageEvent.getMessageData());
}