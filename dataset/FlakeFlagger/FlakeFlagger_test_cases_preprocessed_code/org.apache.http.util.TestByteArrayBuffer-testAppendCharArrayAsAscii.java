@Test public void testAppendCharArrayAsAscii() throws Exception {
Assert.assertEquals(s1 + s2,new String(buffer.toByteArray(),"US-ASCII"));
}