@Test public void testAppendISOByteArray() throws Exception {
Assert.assertNotNull(ch);
Assert.assertEquals(5,ch.length);
Assert.assertEquals(0x00,ch[0]);
Assert.assertEquals(0x20,ch[1]);
Assert.assertEquals(0x7F,ch[2]);
Assert.assertEquals(0x80,ch[3]);
Assert.assertEquals(0xFF,ch[4]);
}