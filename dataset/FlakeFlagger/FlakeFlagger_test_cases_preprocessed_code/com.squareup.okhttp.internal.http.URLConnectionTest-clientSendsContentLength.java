@Test public void clientSendsContentLength() throws Exception {
OutputStream out=connection.getOutputStream();//ET
assertEquals("A",readAscii(connection.getInputStream(),Integer.MAX_VALUE));//ET
}