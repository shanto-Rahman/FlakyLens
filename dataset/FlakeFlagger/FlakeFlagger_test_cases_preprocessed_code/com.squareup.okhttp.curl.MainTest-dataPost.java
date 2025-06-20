@Test public void dataPost(){
assertEquals("POST",request.method());
assertEquals("http://example.com",request.urlString());
assertEquals("application/x-form-urlencoded; charset=utf-8",body.contentType().toString());
assertEquals("foo",bodyAsString(body));
}