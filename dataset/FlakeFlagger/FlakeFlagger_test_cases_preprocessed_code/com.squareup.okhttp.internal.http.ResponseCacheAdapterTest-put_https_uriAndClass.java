@Test public void put_https_uriAndClass() throws Exception {
assertEquals("https",serverUrl.getProtocol());
assertTrue(urlConnection instanceof HttpsURLConnection);
assertEquals(toUri(serverUrl),uri);
assertEquals(serverUrl,urlConnection.getURL());
}