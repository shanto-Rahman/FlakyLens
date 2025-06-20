@Test public void fruit1() throws Exception {
assertNotNull(fsList);
assertEquals(1,fsList.size());
assertNotNull(fs0);
assertEquals("fs0",fs0.getName());
assertTrue(fruit0 instanceof Fruit);
assertEquals("blue",fruit0.getName());
}