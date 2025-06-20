@Test public void redirectedPostStripsRequestBodyHeaders() throws Exception {
connection.addRequestProperty("Content-Length","4");//ET
connection.addRequestProperty("Content-Type","text/plain; charset=utf-8");//ET
connection.addRequestProperty("Transfer-Encoding","identity");//ET
OutputStream outputStream=connection.getOutputStream();//ET
assertEquals("Page 2",readAscii(connection.getInputStream(),Integer.MAX_VALUE));//ET
assertEquals("POST /page1 HTTP/1.1",server.takeRequest().getRequestLine());
assertEquals("GET /page2 HTTP/1.1",page2.getRequestLine());
}