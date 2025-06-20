@SuppressWarnings("unchecked") @Test public void testKeySanitizationWithCustomKeysByEnvironment() throws Exception {
assertEquals("123456",((Map<String,Object>)env.get("systemProperties")).get("dbPassword"));
assertEquals("******",((Map<String,Object>)env.get("systemProperties")).get("apiKey"));
}