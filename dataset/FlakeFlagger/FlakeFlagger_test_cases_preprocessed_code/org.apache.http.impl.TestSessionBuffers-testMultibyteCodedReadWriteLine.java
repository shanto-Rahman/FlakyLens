@Test public void testMultibyteCodedReadWriteLine() throws Exception {
Assert.assertEquals(expected,bytesWritten);
Assert.assertEquals(s1,inbuffer.readLine());
Assert.assertEquals(s2,inbuffer.readLine());
Assert.assertEquals(s3,inbuffer.readLine());
Assert.assertNull(inbuffer.readLine());
Assert.assertNull(inbuffer.readLine());
Assert.assertEquals(expected,bytesRead);
}