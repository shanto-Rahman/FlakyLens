@Test(timeout=15000) public void testSlowNM() throws Exception {
  conf=new Configuration();
  int maxAttempts=1;
  conf.setInt(MRJobConfig.MAP_MAX_ATTEMPTS,maxAttempts);
  conf.setBoolean(MRJobConfig.JOB_UBERTASK_ENABLE,false);
  conf.setInt("yarn.rpc.nm-command-timeout",3000);
  conf.set(YarnConfiguration.IPC_RPC_IMPL,HadoopYarnProtoRPC.class.getName());
  YarnRPC rpc=YarnRPC.create(conf);
  String bindAddr="localhost:0";
  InetSocketAddress addr=NetUtils.createSocketAddr(bindAddr);
  NMTokenSecretManagerInNM tokenSecretManager=new NMTokenSecretManagerInNM();
  MasterKey masterKey=Records.newRecord(MasterKey.class);
  masterKey.setBytes(ByteBuffer.wrap("key".getBytes()));
  tokenSecretManager.setMasterKey(masterKey);
  conf.set(CommonConfigurationKeysPublic.HADOOP_SECURITY_AUTHENTICATION,"token");
  server=rpc.getServer(ContainerManagementProtocol.class,new DummyContainerManager(),addr,conf,tokenSecretManager,1);
  server.start();
  MRApp app=new MRAppWithSlowNM(tokenSecretManager);
  try {
    Job job=app.submit(conf);
    app.waitForState(job,JobState.RUNNING);
    Map<TaskId,Task> tasks=job.getTasks();
    Assert.assertEquals("Num tasks is not correct",1,tasks.size());
    Task task=tasks.values().iterator().next();
    app.waitForState(task,TaskState.SCHEDULED);
    Map<TaskAttemptId,TaskAttempt> attempts=tasks.values().iterator().next().getAttempts();
    Assert.assertEquals("Num attempts is not correct",maxAttempts,attempts.size());
    TaskAttempt attempt=attempts.values().iterator().next();
    app.waitForInternalState((TaskAttemptImpl)attempt,TaskAttemptStateInternal.ASSIGNED);
    app.waitForState(job,JobState.FAILED);
    String diagnostics=attempt.getDiagnostics().toString();
    LOG.info("attempt.getDiagnostics: " + diagnostics);
    Assert.assertTrue(diagnostics.contains("Container launch failed for " + "container_0_0000_01_000000 : "));
    Assert.assertTrue(diagnostics.contains("java.net.SocketTimeoutException: 3000 millis timeout while waiting for channel"));
  }
  finally {
    server.stop();
    app.stop();
  }
}
