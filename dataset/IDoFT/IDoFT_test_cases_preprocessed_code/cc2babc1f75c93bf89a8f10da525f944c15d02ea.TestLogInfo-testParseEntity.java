@Test public void testParseEntity() throws Exception {
assertNotNull(entity3);
assertEquals("Failed to read out entity new",entityNew.getStartTime(),entity3.getStartTime());
}