@Test public void put_uriAndClass() throws Exception {
assertTrue(urlConnection instanceof HttpURLConnection);
assertFalse(urlConnection instanceof HttpsURLConnection);
assertEquals(toUri(serverUrl),uri);
assertEquals(serverUrl,urlConnection.getURL());
}