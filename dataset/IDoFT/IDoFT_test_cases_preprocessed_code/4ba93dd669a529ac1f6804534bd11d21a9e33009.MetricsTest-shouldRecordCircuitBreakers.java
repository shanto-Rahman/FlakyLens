@Test void shouldRecordCircuitBreakers(){
assertEquals(2,timers("http.client.circuit-breakers").size());
assertNotNull(timer);
assertEquals("bar",timer.getId().getTag("client_id"));
assertEquals(4,timer.count());
assertNotNull(timer);
assertEquals("OPEN",timer.getId().getTag("state"));
assertEquals("bar",timer.getId().getTag("client_id"));
assertEquals(4,timer.count());
}