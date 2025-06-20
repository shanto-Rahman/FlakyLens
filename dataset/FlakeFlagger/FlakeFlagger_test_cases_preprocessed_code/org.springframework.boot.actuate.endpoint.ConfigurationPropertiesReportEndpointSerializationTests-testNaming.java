@Test @SuppressWarnings("unchecked") public void testNaming() throws Exception {
assertNotNull(nestedProperties);
assertEquals("foo",nestedProperties.get("prefix"));
assertNotNull(map);
assertEquals(1,map.size());
assertEquals("foo",map.get("name"));
}