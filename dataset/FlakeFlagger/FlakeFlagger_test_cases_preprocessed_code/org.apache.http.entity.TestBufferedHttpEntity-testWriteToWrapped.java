@Test public void testWriteToWrapped() throws Exception {
Assert.assertNotNull(bytes2);
Assert.assertEquals(bytes.length,bytes2.length);
Assert.assertEquals(bytes[i],bytes2[i]);
Assert.assertNotNull(bytes2);
Assert.assertEquals(bytes.length,bytes2.length);
Assert.assertEquals(bytes[i],bytes2[i]);
Assert.fail("IllegalArgumentException should have been thrown");
}