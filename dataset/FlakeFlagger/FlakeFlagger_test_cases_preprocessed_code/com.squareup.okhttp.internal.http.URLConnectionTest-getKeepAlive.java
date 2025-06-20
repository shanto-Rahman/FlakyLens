@Test public void getKeepAlive() throws Exception {
InputStream input=connection1.getInputStream();//ET
assertEquals("ABC",readAscii(input,Integer.MAX_VALUE));
connection2.getInputStream();//ET
fail();
}