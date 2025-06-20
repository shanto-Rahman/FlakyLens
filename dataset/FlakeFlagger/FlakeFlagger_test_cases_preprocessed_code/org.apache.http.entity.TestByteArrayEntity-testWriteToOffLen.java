@Test public void testWriteToOffLen() throws Exception {
Assert.assertNotNull(bytes2);
Assert.assertEquals(len,bytes2.length);
Assert.assertEquals(bytes[i + off],bytes2[i]);
Assert.assertNotNull(bytes2);
Assert.assertEquals(len,bytes2.length);
Assert.assertEquals(bytes[i + off],bytes2[i]);
Assert.fail("IllegalArgumentException should have been thrown");
}