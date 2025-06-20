@Test public void responseSourceHeaderFetched() throws IOException {
assertEquals("A",readAscii(connection));
assertEquals(ResponseSource.NETWORK + " 200",source);
}