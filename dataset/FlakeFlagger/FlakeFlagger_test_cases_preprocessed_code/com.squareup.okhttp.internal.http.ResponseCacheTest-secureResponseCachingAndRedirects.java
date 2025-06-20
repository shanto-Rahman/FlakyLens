@Test public void secureResponseCachingAndRedirects() throws IOException {
assertEquals("ABC",readAscii(connection1));
assertNotNull(connection1.getCipherSuite());
assertEquals("ABC",readAscii(connection2));
assertNotNull(connection2.getCipherSuite());
assertEquals(connection1.getCipherSuite(),connection2.getCipherSuite());
}