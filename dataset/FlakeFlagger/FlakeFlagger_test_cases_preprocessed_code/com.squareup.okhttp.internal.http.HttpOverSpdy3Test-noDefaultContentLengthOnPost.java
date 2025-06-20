/** 
 * An output stream can be written to more than once, so we can't guess content length. 
 */
@Test public void noDefaultContentLengthOnPost() throws Exception {
assertEquals("POST /foo HTTP/1.1",request.getRequestLine());
assertArrayEquals(postBytes,request.getBody());
assertNull(request.getHeader("Content-Length"));
}