@Test public void authenticateWithPost() throws Exception {
OutputStream outputStream=connection.getOutputStream();//ET
assertEquals("Successful auth!",readAscii(connection.getInputStream(),Integer.MAX_VALUE));//ET
assertEquals("POST / HTTP/1.1",request.getRequestLine());
assertEquals(Arrays.toString(requestBody),Arrays.toString(request.getBody()));
}