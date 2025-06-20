@Test(timeout=30000) public void testNNBenchCreateReadAndDelete() throws Exception {
assertTrue("create_write should create the file",getFileSystem().exists(path));
assertFalse("Delete operation should delete the file",getFileSystem().exists(path));
}