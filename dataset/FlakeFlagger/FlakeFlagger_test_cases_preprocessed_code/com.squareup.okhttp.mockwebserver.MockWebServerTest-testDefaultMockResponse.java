public void testDefaultMockResponse(){
assertEquals(Arrays.asList("Content-Length: 0"),response.getHeaders());
assertEquals("HTTP/1.1 200 OK",response.getStatus());
}