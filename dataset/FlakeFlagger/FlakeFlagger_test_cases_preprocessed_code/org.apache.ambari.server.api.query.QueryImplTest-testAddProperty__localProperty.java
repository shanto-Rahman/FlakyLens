@Test public void testAddProperty__localProperty(){
assertEquals(1,query.getProperties().size());
assertEquals(Collections.singleton("property"),query.getProperties().get("category"));
assertEquals(2,query.getProperties().size());
assertEquals(Collections.singleton("property2"),query.getProperties().get(null));
}