@Test public void writeReadByteBufferTest() throws IOException {
Assert.assertEquals(bufs.get(k),Utils.readByteBuffer(dis));
Assert.assertEquals(buf,Utils.readByteBuffer(dis));
}