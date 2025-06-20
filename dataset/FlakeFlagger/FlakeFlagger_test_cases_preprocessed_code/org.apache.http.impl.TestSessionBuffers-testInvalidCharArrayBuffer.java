@Test public void testInvalidCharArrayBuffer() throws Exception {
Assert.fail("IllegalArgumentException should have been thrown");
Assert.assertEquals(0,bytesRead);
}