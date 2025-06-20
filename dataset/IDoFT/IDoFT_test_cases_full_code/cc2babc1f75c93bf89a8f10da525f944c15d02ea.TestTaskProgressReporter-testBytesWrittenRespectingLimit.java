@Test(timeout=10000) public void testBytesWrittenRespectingLimit() throws Exception {
  testBytesWrittenLimit(LOCAL_BYTES_WRITTEN + 1024,false);
}
