@Test public void shouldRecordRetries(){
assertEquals(2,timers.size());
assertEquals("1",first.getId().getTag("retries"));
assertEquals("foo",first.getId().getTag("clientId"));
assertEquals("2",second.getId().getTag("retries"));
assertEquals("foo",second.getId().getTag("clientId"));
}