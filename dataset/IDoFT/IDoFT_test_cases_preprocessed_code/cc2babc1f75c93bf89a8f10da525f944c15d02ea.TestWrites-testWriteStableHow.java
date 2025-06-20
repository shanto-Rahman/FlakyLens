@Test public void testWriteStableHow() throws IOException, InterruptedException {
assertTrue(Arrays.equals(buffer,readRsp.getData().array()));
assertTrue(Arrays.equals(buffer,readRsp2.getData().array()));
assertTrue(status.getLen() == 10);
if (cluster != null) {
}
}