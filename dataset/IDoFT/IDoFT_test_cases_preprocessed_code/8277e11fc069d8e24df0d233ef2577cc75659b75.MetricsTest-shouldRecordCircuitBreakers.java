@Test public void shouldRecordCircuitBreakers(){
assertEquals(2,timers.size());
assertEquals("HALF_OPEN",halfOpen.getId().getTag("state"));
assertEquals("bar",halfOpen.getId().getTag("clientId"));
assertEquals(4,halfOpen.count());
assertEquals("OPEN",open.getId().getTag("state"));
assertEquals("bar",open.getId().getTag("clientId"));
assertEquals(4,open.count());
}