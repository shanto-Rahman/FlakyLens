@Test public void testWriteTo() throws Exception {
Assert.assertNotNull(bytes2);
Assert.assertEquals(7,bytes2.length);
Assert.assertEquals("Message",s);
Assert.assertNotNull(bytes2);
Assert.assertEquals(bytes.length,bytes2.length);
Assert.assertNotNull(bytes2);
Assert.assertEquals(bytes.length,bytes2.length);
Assert.fail("IllegalArgumentException should have been thrown");
}