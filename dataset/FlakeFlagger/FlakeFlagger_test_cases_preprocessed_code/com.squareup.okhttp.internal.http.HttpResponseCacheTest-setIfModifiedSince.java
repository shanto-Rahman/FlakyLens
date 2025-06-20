/** 
 * Confirm that    {@link URLConnection#setIfModifiedSince}  causes anIf-Modified-Since header with a GMT timestamp. https://code.google.com/p/android/issues/detail?id=66135
 */
@Test public void setIfModifiedSince() throws Exception {
assertEquals("A",readAscii(connection));
assertEquals("Sat, 01 Mar 2014 09:30:00 GMT",ifModifiedSinceHeader);
}