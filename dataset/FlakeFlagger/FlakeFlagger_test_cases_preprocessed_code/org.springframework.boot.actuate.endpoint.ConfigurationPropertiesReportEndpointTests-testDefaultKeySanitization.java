@Test @SuppressWarnings("unchecked") public void testDefaultKeySanitization() throws Exception {
assertNotNull(nestedProperties);
assertEquals("******",nestedProperties.get("dbPassword"));
assertEquals("654321",nestedProperties.get("myTestProperty"));
}