@Test public void testReadWriteByte() throws Exception {
Assert.assertEquals(out.length,bytesWritten);
Assert.assertEquals(out.length,tmp.length);
Assert.assertEquals(out[i],tmp[i]);
Assert.assertEquals(out[i],in[i]);
Assert.assertEquals(-1,inbuffer.read());
Assert.assertEquals(-1,inbuffer.read());
Assert.assertEquals(out.length,bytesRead);
}