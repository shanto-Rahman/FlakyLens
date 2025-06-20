@Test public void testBasicReadWriteLine() throws Exception {
Assert.assertEquals(teststrs[i],inbuf.readLine(true));
Assert.assertNull(inbuf.readLine(true));
Assert.assertNull(inbuf.readLine(true));
}