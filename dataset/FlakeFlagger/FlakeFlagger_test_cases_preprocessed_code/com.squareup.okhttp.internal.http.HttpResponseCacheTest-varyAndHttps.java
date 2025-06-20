@Test public void varyAndHttps() throws Exception {
assertEquals("A",readAscii(connection1));
assertEquals("A",readAscii(connection2));
}