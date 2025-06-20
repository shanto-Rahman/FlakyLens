@Test public void testComplexReadWriteLine() throws Exception {
Assert.assertEquals("a",inbuf.readLine(true));
Assert.assertEquals("",inbuf.readLine(true));
Assert.assertEquals("\r",inbuf.readLine(true));
Assert.assertEquals("",inbuf.readLine(true));
Assert.assertEquals(s1,inbuf.readLine(true));
Assert.assertEquals(s2,inbuf.readLine(true));
Assert.assertEquals(s3,inbuf.readLine(true));
Assert.assertEquals("a",inbuf.readLine(true));
Assert.assertNull(inbuf.readLine(true));
Assert.assertNull(inbuf.readLine(true));
}