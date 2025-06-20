public void testRegularResponse() throws Exception {
assertEquals(HttpURLConnection.HTTP_OK,connection.getResponseCode());
assertEquals("hello world",reader.readLine());
assertEquals("GET / HTTP/1.1",request.getRequestLine());
assertTrue(request.getHeaders().contains("Accept-Language: en-US"));
}