@Test public void simple(){
assertEquals("GET",request.method());
assertEquals("http://example.com",request.urlString());
assertNull(request.body());
}