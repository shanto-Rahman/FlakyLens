@SuppressWarnings("unchecked") @Test public void testKeySanitizationWithCustomPatternByEnvironment() throws Exception {
assertNotNull(nestedProperties);
assertEquals("******",nestedProperties.get("dbPassword"));
assertEquals("654321",nestedProperties.get("myTestProperty"));
}