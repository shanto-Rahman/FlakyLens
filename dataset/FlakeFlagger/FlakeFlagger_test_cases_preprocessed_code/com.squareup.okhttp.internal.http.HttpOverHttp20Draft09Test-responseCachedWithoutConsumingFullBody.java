@Test public void responseCachedWithoutConsumingFullBody() throws IOException {
assertEquals("AB",readAscii(in1,2));
assertEquals("ABCD",readAscii(in2,Integer.MAX_VALUE));
}