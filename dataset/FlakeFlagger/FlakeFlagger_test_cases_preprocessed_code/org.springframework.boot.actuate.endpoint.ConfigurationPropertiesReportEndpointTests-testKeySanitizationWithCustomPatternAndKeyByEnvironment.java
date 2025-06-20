@SuppressWarnings("unchecked") @Test public void testKeySanitizationWithCustomPatternAndKeyByEnvironment() throws Exception {
assertNotNull(nestedProperties);
assertEquals("******",nestedProperties.get("dbPassword"));
assertEquals("******",nestedProperties.get("myTestProperty"));
}