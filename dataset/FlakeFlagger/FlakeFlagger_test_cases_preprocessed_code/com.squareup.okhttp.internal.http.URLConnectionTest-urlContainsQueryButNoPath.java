@Test public void urlContainsQueryButNoPath() throws Exception {
assertEquals("A",readAscii(client.open(url).getInputStream(),Integer.MAX_VALUE));
assertEquals("GET /?query HTTP/1.1",request.getRequestLine());
}