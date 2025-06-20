@Test public void testNonAsciiReadWriteLine() throws Exception {
Assert.assertEquals(expected,bytesWritten);
Assert.assertEquals(len,SWISS_GERMAN_HELLO.length);
Assert.assertEquals(s1,buf.toString());
Assert.assertNull(inbuffer.readLine());
Assert.assertNull(inbuffer.readLine());
Assert.assertEquals(expected,bytesRead);
}