@Test @TestHdfs public void testHadoopFileSystem() throws Exception {
  Configuration conf=TestHdfsHelper.getHdfsConf();
  FileSystem fs=FileSystem.get(conf);
  try {
    OutputStream os=fs.create(new Path(TestHdfsHelper.getHdfsTestDir(),"foo"));
    os.write(new byte[]{1});
    os.close();
    InputStream is=fs.open(new Path(TestHdfsHelper.getHdfsTestDir(),"foo"));
    assertEquals(is.read(),1);
    assertEquals(is.read(),-1);
    is.close();
  }
  finally {
    fs.close();
  }
}
