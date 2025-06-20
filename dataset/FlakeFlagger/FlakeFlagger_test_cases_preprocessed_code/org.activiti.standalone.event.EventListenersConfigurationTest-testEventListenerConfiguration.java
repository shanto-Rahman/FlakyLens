public void testEventListenerConfiguration(){
assertNotNull(listener);
assertEquals(1,listener.getEventsReceived().size());
assertEquals(event,listener.getEventsReceived().get(0));
}