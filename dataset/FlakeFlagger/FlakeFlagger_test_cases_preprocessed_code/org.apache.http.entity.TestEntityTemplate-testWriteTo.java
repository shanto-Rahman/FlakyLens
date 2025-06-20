@Test public void testWriteTo() throws Exception {
Assert.assertNotNull(bytes2);
Assert.assertEquals(1,bytes2.length);
Assert.fail("IllegalArgumentException should have been thrown");
}