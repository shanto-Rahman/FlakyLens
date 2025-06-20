@Test public void getOutputAfterGetInputStreamFails() throws Exception {
connection.getInputStream();//ET
connection.getOutputStream();//ET
fail();
}