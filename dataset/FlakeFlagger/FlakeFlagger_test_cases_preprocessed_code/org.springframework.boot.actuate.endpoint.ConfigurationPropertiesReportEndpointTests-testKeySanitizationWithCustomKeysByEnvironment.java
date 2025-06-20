@SuppressWarnings("unchecked") @Test public void testKeySanitizationWithCustomKeysByEnvironment() throws Exception {
assertNotNull(nestedProperties);
assertEquals("123456",nestedProperties.get("dbPassword"));
assertEquals("******",nestedProperties.get("myTestProperty"));
}