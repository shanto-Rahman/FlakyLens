@Test @SuppressWarnings("unchecked") public void testNaming() throws Exception {
assertNotNull(nestedProperties);
assertEquals("test",nestedProperties.get("prefix"));
assertNotNull(nestedProperties.get("properties"));
}