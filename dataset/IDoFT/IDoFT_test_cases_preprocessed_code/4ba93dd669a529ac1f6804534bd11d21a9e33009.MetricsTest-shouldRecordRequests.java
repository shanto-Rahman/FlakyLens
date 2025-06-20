@Test void shouldRecordRequests(){
assertEquals(2,timers("http.client.requests").size());
assertNotNull(timer);
assertEquals("GET",timer.getId().getTag("http.method"));
assertNotNull(timer);
assertEquals("GET",timer.getId().getTag("http.method"));
}