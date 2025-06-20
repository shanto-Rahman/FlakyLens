@Test @SuppressWarnings("unchecked") public void testNaming() throws Exception {
assertNotNull(nestedProperties);
assertEquals("other",nestedProperties.get("prefix"));
assertNotNull(nestedProperties.get("properties"));
}