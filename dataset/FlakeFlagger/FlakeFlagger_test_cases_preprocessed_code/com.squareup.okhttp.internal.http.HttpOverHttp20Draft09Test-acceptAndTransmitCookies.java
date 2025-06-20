@Test public void acceptAndTransmitCookies() throws Exception {
assertEquals(Collections.singletonMap("Cookie",Arrays.asList("c=oreo")),cookieManager.get(url.toURI(),requestHeaders));
}