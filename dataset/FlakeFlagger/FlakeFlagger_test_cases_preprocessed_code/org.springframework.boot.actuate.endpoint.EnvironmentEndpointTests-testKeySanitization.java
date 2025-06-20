@SuppressWarnings("unchecked") @Test public void testKeySanitization() throws Exception {
assertEquals("******",((Map<String,Object>)env.get("systemProperties")).get("dbPassword"));
assertEquals("******",((Map<String,Object>)env.get("systemProperties")).get("apiKey"));
}