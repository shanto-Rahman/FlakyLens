@Test public void testConstructor() throws Exception {
Assert.assertEquals(16,buffer.capacity());
Assert.assertEquals(0,buffer.length());
Assert.assertNotNull(buffer.buffer());
Assert.assertEquals(16,buffer.buffer().length);
Assert.fail("IllegalArgumentException should have been thrown");
}