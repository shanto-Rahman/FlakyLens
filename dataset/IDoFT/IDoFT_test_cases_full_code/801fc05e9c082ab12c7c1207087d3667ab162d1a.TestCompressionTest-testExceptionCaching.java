@Test public void testExceptionCaching(){
  try {
    CompressionTest.testCompression(Compression.Algorithm.LZO);
    fail();
  }
 catch (  IOException e) {
    assertNotNull(e.getCause());
  }
  try {
    CompressionTest.testCompression(Compression.Algorithm.LZO);
    fail();
  }
 catch (  IOException e) {
    assertNull(e.getCause());
  }
  assertFalse(CompressionTest.testCompression("LZO"));
}
