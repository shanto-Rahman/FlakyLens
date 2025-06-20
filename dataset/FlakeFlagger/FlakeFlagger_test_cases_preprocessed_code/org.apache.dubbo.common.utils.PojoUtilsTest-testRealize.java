@Test public void testRealize() throws Exception {
assertTrue(obj instanceof LinkedHashMap);
assertTrue(outputObject instanceof LinkedHashMap);
assertTrue(objects[0] instanceof LinkedHashMap);
assertEquals(objects[0],outputObject);
}