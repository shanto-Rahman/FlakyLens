@Test(expected=RuntimeException.class) public void testProdThrowsError() throws Exception {
FileUtils.deleteDirectory(new File(baseDirWithoutTrailingSlash));//RO
}