@Test public void testShufflePermissions() throws Exception {
  JobConf conf=new JobConf();
  conf.set(CommonConfigurationKeys.FS_PERMISSIONS_UMASK_KEY,"077");
  conf.set(MRConfig.LOCAL_DIR,TEST_ROOT_DIR.getAbsolutePath());
  MapOutputFile mof=new MROutputFiles();
  mof.setConf(conf);
  TaskAttemptID attemptId=new TaskAttemptID("12345",1,TaskType.MAP,1,1);
  MapTask mockTask=mock(MapTask.class);
  doReturn(mof).when(mockTask).getMapOutputFile();
  doReturn(attemptId).when(mockTask).getTaskID();
  doReturn(new Progress()).when(mockTask).getSortPhase();
  TaskReporter mockReporter=mock(TaskReporter.class);
  doReturn(new Counter()).when(mockReporter).getCounter(any(TaskCounter.class));
  MapOutputCollector.Context ctx=new MapOutputCollector.Context(mockTask,conf,mockReporter);
  MapOutputBuffer<Object,Object> mob=new MapOutputBuffer<>();
  mob.init(ctx);
  mob.flush();
  mob.close();
  Path outputFile=mof.getOutputFile();
  FileSystem lfs=FileSystem.getLocal(conf);
  FsPermission perms=lfs.getFileStatus(outputFile).getPermission();
  Assert.assertEquals("Incorrect output file perms",(short)0640,perms.toShort());
  Path indexFile=mof.getOutputIndexFile();
  perms=lfs.getFileStatus(indexFile).getPermission();
  Assert.assertEquals("Incorrect index file perms",(short)0640,perms.toShort());
}
