@Test public void put_requestHeadersPartlyUnavailable() throws Exception {
fail();
assertEquals("value",urlConnection.getRequestProperty("key"));
}