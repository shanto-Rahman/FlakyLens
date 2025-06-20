@Test public void serverSendsPushPromise_GET() throws Exception {
assertEquals(200,connection.getResponseCode());
assertEquals("Sweet",connection.getResponseMessage());
assertEquals("GET /foo HTTP/1.1",request.getRequestLine());
assertEquals("GET /foo/bar HTTP/1.1",pushedRequest.getRequestLine());
assertEquals(Arrays.asList("foo: bar"),pushedRequest.getHeaders());
}