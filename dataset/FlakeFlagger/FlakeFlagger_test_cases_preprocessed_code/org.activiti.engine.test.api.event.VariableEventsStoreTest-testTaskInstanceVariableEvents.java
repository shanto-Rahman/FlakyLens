public void testTaskInstanceVariableEvents() throws Exception {
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_CREATED,listener.getEventsReceived().get(0).getType());
assertEquals(1,managementService.getEventLogEntries(null,null).size());
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.VARIABLE_DELETED,listener.getEventsReceived().get(1).getType());
assertEquals(2,managementService.getEventLogEntries(null,null).size());
assertEquals(6,listener.getEventsReceived().size());
assertEquals(6,managementService.getEventLogEntries(null,null).size());
}