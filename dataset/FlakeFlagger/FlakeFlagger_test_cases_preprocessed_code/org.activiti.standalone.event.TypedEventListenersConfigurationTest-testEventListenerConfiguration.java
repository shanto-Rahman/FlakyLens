public void testEventListenerConfiguration(){
assertNotNull(listener);
assertEquals(1,listener.getEventsReceived().size());
assertEquals(event,listener.getEventsReceived().get(0));
assertEquals(2,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENTITY_DELETED,listener.getEventsReceived().get(0).getType());
assertEquals(ActivitiEventType.ENTITY_UPDATED,listener.getEventsReceived().get(1).getType());
assertTrue(listener.getEventsReceived().isEmpty());
}