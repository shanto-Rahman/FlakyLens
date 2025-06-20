/** 
 * For Last-Modified and Date headers, we should echo the date back in the exact format we were served.
 */
@Test public void retainServedDateFormat() throws Exception {
Date lastModifiedDate=new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(-1));
Date servedDate=new Date(System.currentTimeMillis() + TimeUnit.HOURS.toMillis(-2));
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertEquals("A",readAscii(openConnection(server.getUrl("/"))));
assertNull(request1.getHeader("If-Modified-Since"));
assertEquals(lastModifiedString,request2.getHeader("If-Modified-Since"));
}