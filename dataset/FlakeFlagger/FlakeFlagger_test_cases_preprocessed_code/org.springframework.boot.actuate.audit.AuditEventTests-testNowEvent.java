@Test public void testNowEvent() throws Exception {
assertEquals("b",event.getData().get("a"));
assertEquals("UNKNOWN",event.getType());
assertEquals("phil",event.getPrincipal());
assertNotNull(event.getTimestamp());
}