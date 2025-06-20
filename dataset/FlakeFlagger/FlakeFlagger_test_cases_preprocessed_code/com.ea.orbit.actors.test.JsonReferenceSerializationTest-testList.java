@Test public void testList() throws Exception {
assertEquals(json,listJson);
assertEquals(actors,mapper.readValue(listJson,mapper.getTypeFactory().constructCollectionType(List.class,ISomeActor.class)));
}