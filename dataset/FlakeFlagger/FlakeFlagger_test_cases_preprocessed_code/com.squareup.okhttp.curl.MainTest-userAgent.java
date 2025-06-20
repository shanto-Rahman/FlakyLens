@Test public void userAgent(){
assertEquals("GET",request.method());
assertEquals("http://example.com",request.urlString());
assertEquals("foo",request.header("User-Agent"));
assertNull(request.body());
}