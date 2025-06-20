@SuppressWarnings("unchecked") @Test public void testKeySanitizationWithCustomPattern() throws Exception {
assertEquals("******",((Map<String,Object>)env.get("systemProperties")).get("dbPassword"));
assertEquals("123456",((Map<String,Object>)env.get("systemProperties")).get("apiKey"));
}