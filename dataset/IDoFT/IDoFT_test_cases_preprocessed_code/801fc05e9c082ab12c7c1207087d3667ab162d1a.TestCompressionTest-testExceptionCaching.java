@Test public void testExceptionCaching(){
fail();
assertNotNull(e.getCause());
fail();
assertNull(e.getCause());
assertFalse(CompressionTest.testCompression("LZO"));
}