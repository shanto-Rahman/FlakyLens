@Test public void testDeserialize() throws Exception {
assertEquals(actor,mapper.readValue(json,ISomeActor.class));
}