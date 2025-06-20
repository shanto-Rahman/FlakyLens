@Test public void testSerialize() throws Exception {
assertEquals(json,mapper.writeValueAsString(actor));
}