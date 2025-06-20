@Test public void referer(){
assertEquals("GET",request.method());
assertEquals("http://example.com",request.urlString());
assertEquals("foo",request.header("Referer"));
assertNull(request.body());
}