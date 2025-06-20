/** 
 * We had a bug where we attempted to gunzip responses that didn't have a body. This only came up with 304s since that response code can include headers (like "Content-Encoding") without any content to go along with it. https://github.com/square/okhttp/issues/358
 */
@Test public void noTransparentGzipFor304NotModified() throws Exception {
assertEquals(HttpURLConnection.HTTP_NOT_MODIFIED,connection1.getResponseCode());
assertEquals(HttpURLConnection.HTTP_OK,connection2.getResponseCode());
assertEquals(0,requestA.getSequenceNumber());
assertEquals(1,requestB.getSequenceNumber());
}