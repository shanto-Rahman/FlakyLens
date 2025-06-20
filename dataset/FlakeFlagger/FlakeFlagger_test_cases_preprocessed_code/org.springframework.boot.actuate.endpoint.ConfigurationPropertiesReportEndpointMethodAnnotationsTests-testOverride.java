@Test @SuppressWarnings("unchecked") public void testOverride() throws Exception {
assertNotNull(nestedProperties);
assertEquals("other",nestedProperties.get("prefix"));
assertNotNull(nestedProperties.get("properties"));
}