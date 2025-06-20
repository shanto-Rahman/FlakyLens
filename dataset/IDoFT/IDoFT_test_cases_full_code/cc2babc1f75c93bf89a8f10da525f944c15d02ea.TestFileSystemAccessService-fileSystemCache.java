@Test @TestDir @TestHdfs public void fileSystemCache() throws Exception {
  String dir=TestDirHelper.getTestDir().getAbsolutePath();
  String services=StringUtils.join(",",Arrays.asList(InstrumentationService.class.getName(),SchedulerService.class.getName(),FileSystemAccessService.class.getName()));
  Configuration hadoopConf=new Configuration(false);
  hadoopConf.set(CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY,TestHdfsHelper.getHdfsConf().get(CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY));
  createHadoopConf(hadoopConf);
  Configuration conf=new Configuration(false);
  conf.set("server.services",services);
  conf.set("server.hadoop.filesystem.cache.purge.frequency","1");
  conf.set("server.hadoop.filesystem.cache.purge.timeout","1");
  Server server=new Server("server",dir,dir,dir,dir,conf);
  try {
    server.init();
    FileSystemAccess hadoop=server.get(FileSystemAccess.class);
    FileSystem fs1=hadoop.createFileSystem("u",hadoop.getFileSystemConfiguration());
    Assert.assertNotNull(fs1);
    fs1.mkdirs(new Path("/tmp/foo1"));
    hadoop.releaseFileSystem(fs1);
    fs1.mkdirs(new Path("/tmp/foo2"));
    FileSystem fs2=hadoop.createFileSystem("u",hadoop.getFileSystemConfiguration());
    Assert.assertEquals(fs1,fs2);
    Thread.sleep(4 * 1000);
    fs1.mkdirs(new Path("/tmp/foo2"));
    Thread.sleep(4 * 1000);
    fs2.mkdirs(new Path("/tmp/foo"));
    hadoop.releaseFileSystem(fs2);
    Thread.sleep(4 * 1000);
    try {
      fs2.mkdirs(new Path("/tmp/foo"));
      Assert.fail();
    }
 catch (    IOException ex) {
    }
catch (    Exception ex) {
      Assert.fail();
    }
  }
  finally {
    server.destroy();
  }
}
