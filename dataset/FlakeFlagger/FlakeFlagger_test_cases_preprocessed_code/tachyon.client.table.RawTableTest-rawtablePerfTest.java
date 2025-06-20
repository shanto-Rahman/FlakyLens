@Test public void rawtablePerfTest() throws IOException {
Assert.assertEquals(col,table.getColumns());
Assert.assertEquals(col,table.getColumns());
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(10),buf.DATA);
Assert.assertEquals(TestUtils.getIncreasingByteBuffer(10),buf.DATA);
}