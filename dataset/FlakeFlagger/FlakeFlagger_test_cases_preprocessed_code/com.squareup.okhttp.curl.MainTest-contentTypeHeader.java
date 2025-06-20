@Test public void contentTypeHeader(){
assertEquals("POST",request.method());
assertEquals("http://example.com",request.urlString());
assertEquals("application/json; charset=utf-8",body.contentType().toString());
assertEquals("foo",bodyAsString(body));
}