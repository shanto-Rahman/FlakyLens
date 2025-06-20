@Test public void get_https_allParameters() throws Exception {
assertEquals("https",serverUrl.getProtocol());
assertEquals("https",uri.getScheme());
assertEquals(toUri(serverUrl),uri);
assertEquals("GET",method);
assertTrue("Arbitrary standard header not present",headers.containsKey("User-Agent"));
assertEquals(Collections.singletonList("value1"),headers.get("key1"));
}