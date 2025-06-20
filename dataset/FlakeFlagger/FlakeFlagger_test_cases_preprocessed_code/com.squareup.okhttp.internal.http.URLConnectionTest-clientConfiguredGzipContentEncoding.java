@Test public void clientConfiguredGzipContentEncoding() throws Exception {
InputStream gunzippedIn=new GZIPInputStream(connection.getInputStream());//ET
assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",readAscii(gunzippedIn,Integer.MAX_VALUE));
assertEquals(bodyBytes.length,connection.getContentLength());//ET
}