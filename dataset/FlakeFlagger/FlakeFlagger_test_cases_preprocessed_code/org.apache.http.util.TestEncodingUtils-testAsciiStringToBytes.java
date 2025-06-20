@Test public void testAsciiStringToBytes() throws Exception {
Assert.assertNotNull(data);
Assert.assertEquals(ascii.length,data.length);
Assert.assertEquals(ascii[i],data[i]);
Assert.fail("IllegalArgumentException should have been thrown");
}