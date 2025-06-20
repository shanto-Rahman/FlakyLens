@Test public void testAsciiBytesToString() throws Exception {
Assert.assertEquals(s,EncodingUtils.getAsciiString(s.getBytes("US-ASCII")));
Assert.fail("IllegalArgumentException should have been thrown");
Assert.fail("IllegalArgumentException should have been thrown");
}