@Test public void testMultibyteCodedReadWriteLine() throws Exception {
Assert.assertEquals(s1,inbuf.readLine(true));
Assert.assertEquals(s2,inbuf.readLine(true));
Assert.assertEquals(s3,inbuf.readLine(true));
}