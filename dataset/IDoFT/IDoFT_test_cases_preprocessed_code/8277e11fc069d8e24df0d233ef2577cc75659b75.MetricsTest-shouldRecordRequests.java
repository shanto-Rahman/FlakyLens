@Test public void shouldRecordRequests(){
assertEquals(2,timers.size());
assertEquals("GET",first.getId().getTag("method"));
assertEquals("bar",first.getId().getTag("clientId"));
assertEquals("GET",second.getId().getTag("method"));
assertEquals("foo",second.getId().getTag("clientId"));
}