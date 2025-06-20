@Test public void test2() throws Exception {
assertTrue(checker.isErrorFree(0));
assertTrue(Compare.gzCompare(CoreTestConstants.OUTPUT_DIR_PREFIX + "compress2.txt.gz",CoreTestConstants.TEST_SRC_PREFIX + "witness/compress2.txt.gz"));
}