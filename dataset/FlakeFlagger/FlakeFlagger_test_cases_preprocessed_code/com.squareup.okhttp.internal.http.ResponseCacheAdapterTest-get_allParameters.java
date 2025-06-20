@Test public void get_allParameters() throws Exception {
assertEquals("http",serverUrl.getProtocol());
assertEquals(toUri(serverUrl),uri);
assertEquals("GET",method);
assertTrue("Arbitrary standard header not present",headers.containsKey("User-Agent"));
assertEquals(Collections.singletonList("value1"),headers.get("key1"));
}