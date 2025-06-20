@Test(timeout=30000) public void testNNBenchCreateReadAndDelete() throws Exception {
  runNNBench(createJobConf(),"create_write");
  Path path=new Path(BASE_DIR + "/data/file_0_0");
  assertTrue("create_write should create the file",getFileSystem().exists(path));
  runNNBench(createJobConf(),"open_read");
  runNNBench(createJobConf(),"delete");
  assertFalse("Delete operation should delete the file",getFileSystem().exists(path));
}
