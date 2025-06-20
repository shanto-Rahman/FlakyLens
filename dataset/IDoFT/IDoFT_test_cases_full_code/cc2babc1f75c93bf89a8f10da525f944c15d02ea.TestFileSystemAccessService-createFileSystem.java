@Test @TestDir @TestHdfs public void createFileSystem() throws Exception {
  String dir=TestDirHelper.getTestDir().getAbsolutePath();
  String services=StringUtils.join(",",Arrays.asList(InstrumentationService.class.getName(),SchedulerService.class.getName(),FileSystemAccessService.class.getName()));
  Configuration hadoopConf=new Configuration(false);
  hadoopConf.set(CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY,TestHdfsHelper.getHdfsConf().get(CommonConfigurationKeysPublic.FS_DEFAULT_NAME_KEY));
  createHadoopConf(hadoopConf);
  Configuration conf=new Configuration(false);
  conf.set("server.services",services);
  conf.set("server.hadoop.filesystem.cache.purge.timeout","0");
  Server server=new Server("server",dir,dir,dir,dir,conf);
  server.init();
  FileSystemAccess hadoop=server.get(FileSystemAccess.class);
  FileSystem fs=hadoop.createFileSystem("u",hadoop.getFileSystemConfiguration());
  Assert.assertNotNull(fs);
  fs.mkdirs(new Path("/tmp/foo"));
  hadoop.releaseFileSystem(fs);
  try {
    fs.mkdirs(new Path("/tmp/foo"));
    Assert.fail();
  }
 catch (  IOException ex) {
  }
catch (  Exception ex) {
    Assert.fail();
  }
  server.destroy();
}
