@Test public void testKnownLengthContentToByteArray() throws Exception {
Assert.assertNotNull(bytes2);
Assert.assertEquals(bytes.length,bytes2.length);
Assert.assertEquals(bytes[i],bytes2[i]);
}