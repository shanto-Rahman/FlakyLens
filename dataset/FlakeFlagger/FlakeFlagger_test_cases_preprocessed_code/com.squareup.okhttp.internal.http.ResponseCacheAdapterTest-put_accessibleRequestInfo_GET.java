@Test public void put_accessibleRequestInfo_GET() throws Exception {
assertEquals("GET",httpUrlConnection.getRequestMethod());
assertTrue(httpUrlConnection.getDoInput());
assertFalse(httpUrlConnection.getDoOutput());
}