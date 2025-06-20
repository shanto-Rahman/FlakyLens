@Test @SuppressWarnings("unchecked") public void testKeySanitization() throws Exception {
assertNotNull(nestedProperties);
assertEquals("123456",nestedProperties.get("dbPassword"));
assertEquals("******",nestedProperties.get("myTestProperty"));
}