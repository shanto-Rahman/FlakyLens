public void testEngineEventsTest(){
assertNotNull(listener);
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENGINE_CREATED,listener.getEventsReceived().get(0).getType());
assertEquals(1,listener.getEventsReceived().size());
assertEquals(ActivitiEventType.ENGINE_CLOSED,listener.getEventsReceived().get(0).getType());
}