public void testSetBodyAdjustsHeaders() throws IOException {
assertEquals(Arrays.asList("Content-Length: 3"),response.getHeaders());
assertEquals('A',in.read());
assertEquals('B',in.read());
assertEquals('C',in.read());
assertEquals(-1,in.read());
assertEquals("HTTP/1.1 200 OK",response.getStatus());
}