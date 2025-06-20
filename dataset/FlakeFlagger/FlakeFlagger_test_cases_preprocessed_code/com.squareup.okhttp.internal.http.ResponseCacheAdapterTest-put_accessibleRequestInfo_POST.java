@Test public void put_accessibleRequestInfo_POST() throws Exception {
assertEquals("POST",httpUrlConnection.getRequestMethod());
assertTrue(httpUrlConnection.getDoInput());
assertTrue(httpUrlConnection.getDoOutput());
}