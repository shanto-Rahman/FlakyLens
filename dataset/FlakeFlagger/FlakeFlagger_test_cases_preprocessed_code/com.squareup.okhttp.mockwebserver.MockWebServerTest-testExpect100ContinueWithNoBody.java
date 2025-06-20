public void testExpect100ContinueWithNoBody() throws Exception {
assertEquals(HttpURLConnection.HTTP_OK,connection.getResponseCode());
assertEquals(server.getRequestCount(),1);
assertEquals(request.getRequestLine(),"PUT / HTTP/1.1");
assertEquals("0",request.getHeader("Content-Length"));
assertEquals(0,request.getBodySize());
assertEquals("100-continue",request.getHeader("Expect"));
}