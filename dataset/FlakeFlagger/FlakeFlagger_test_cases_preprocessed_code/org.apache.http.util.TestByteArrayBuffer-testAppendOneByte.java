@Test public void testAppendOneByte() throws Exception {
Assert.assertEquals(4,buffer.capacity());
Assert.assertEquals(8,buffer.capacity());
Assert.assertEquals(6,buffer.length());
Assert.assertEquals(tmp[i],buffer.byteAt(i));
}