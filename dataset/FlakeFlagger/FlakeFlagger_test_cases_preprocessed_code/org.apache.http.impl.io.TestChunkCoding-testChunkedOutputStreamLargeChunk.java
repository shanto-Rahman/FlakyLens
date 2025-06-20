@Test public void testChunkedOutputStreamLargeChunk() throws IOException {
Assert.assertEquals(14,rawdata.length);
Assert.assertEquals('4',rawdata[0]);
Assert.assertEquals('\r',rawdata[1]);
Assert.assertEquals('\n',rawdata[2]);
Assert.assertEquals('1',rawdata[3]);
Assert.assertEquals('2',rawdata[4]);
Assert.assertEquals('3',rawdata[5]);
Assert.assertEquals('4',rawdata[6]);
Assert.assertEquals('\r',rawdata[7]);
Assert.assertEquals('\n',rawdata[8]);
Assert.assertEquals('0',rawdata[9]);
Assert.assertEquals('\r',rawdata[10]);
Assert.assertEquals('\n',rawdata[11]);
Assert.assertEquals('\r',rawdata[12]);
Assert.assertEquals('\n',rawdata[13]);
}