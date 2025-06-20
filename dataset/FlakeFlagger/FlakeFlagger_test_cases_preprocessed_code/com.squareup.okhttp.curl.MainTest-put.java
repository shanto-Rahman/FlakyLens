@Test public void put(){
assertEquals("PUT",request.method());
assertEquals("http://example.com",request.urlString());
assertNull(request.body());
}