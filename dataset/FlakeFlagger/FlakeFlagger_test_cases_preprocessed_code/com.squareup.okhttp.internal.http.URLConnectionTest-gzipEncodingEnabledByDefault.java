/** 
 * This test checks whether connections are gzipped by default. This behavior in not required by the API, so a failure of this test does not imply a bug in the implementation.
 */
@Test public void gzipEncodingEnabledByDefault() throws IOException, InterruptedException {
assertEquals("ABCABCABC",readAscii(connection.getInputStream(),Integer.MAX_VALUE));
assertNull(connection.getContentEncoding());//ET
assertEquals(-1,connection.getContentLength());//ET
}