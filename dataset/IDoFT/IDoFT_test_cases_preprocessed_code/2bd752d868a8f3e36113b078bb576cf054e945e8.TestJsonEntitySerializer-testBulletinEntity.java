@Test public void testBulletinEntity() throws Exception {
assertEquals("{\"bulletin\":{\"category\":\"test\",\"level\":\"INFO\",\"timestamp\":\"" + formattedTimestamp + "\"}}",serialized);
}