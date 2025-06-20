@Test public void testComplexReadWriteLine() throws Exception {
Assert.assertEquals(8,bytesWritten);
Assert.assertEquals(8 + 14 + 2,bytesWritten);
Assert.assertEquals(8 + 14 + 2+ 15+ 2,bytesWritten);
Assert.assertEquals(8 + 14 + 2+ 15+ 2+ 16+ 2,bytesWritten);
Assert.assertEquals(8 + 14 + 2+ 15+ 2+ 16+ 2+ 1,bytesWritten);
Assert.assertEquals("a",inbuffer.readLine());
Assert.assertEquals("",inbuffer.readLine());
Assert.assertEquals("\r",inbuffer.readLine());
Assert.assertEquals("",inbuffer.readLine());
Assert.assertEquals(s1,inbuffer.readLine());
Assert.assertEquals(s2,inbuffer.readLine());
Assert.assertEquals(s3,inbuffer.readLine());
Assert.assertEquals("a",inbuffer.readLine());
Assert.assertNull(inbuffer.readLine());
Assert.assertNull(inbuffer.readLine());
Assert.assertEquals(bytesWritten,bytesRead);
}