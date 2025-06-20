@Test public void testBasicReadWriteLineLargeBuffer() throws Exception {
Assert.assertEquals(expected,bytesWritten);
Assert.assertEquals(teststrs[i],inbuffer.readLine());
Assert.assertNull(inbuffer.readLine());
Assert.assertNull(inbuffer.readLine());
Assert.assertEquals(expected,bytesRead);
}