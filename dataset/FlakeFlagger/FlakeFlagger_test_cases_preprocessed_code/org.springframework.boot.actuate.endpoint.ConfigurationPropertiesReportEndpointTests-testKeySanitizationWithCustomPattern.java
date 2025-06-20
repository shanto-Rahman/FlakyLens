@SuppressWarnings("unchecked") @Test public void testKeySanitizationWithCustomPattern() throws Exception {
assertNotNull(nestedProperties);
assertEquals("******",nestedProperties.get("dbPassword"));
assertEquals("654321",nestedProperties.get("myTestProperty"));
}