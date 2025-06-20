@Test public void test1() throws Exception {
assertTrue(checker.isErrorFree(0));
assertTrue(Compare.gzCompare(CoreTestConstants.OUTPUT_DIR_PREFIX + "compress1.txt.gz",CoreTestConstants.TEST_SRC_PREFIX + "witness/compress1.txt.gz"));
}