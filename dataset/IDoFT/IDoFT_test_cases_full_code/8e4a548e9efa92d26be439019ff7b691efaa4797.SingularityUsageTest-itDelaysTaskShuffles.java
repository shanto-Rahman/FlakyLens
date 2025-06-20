@Test public void itDelaysTaskShuffles(){
  try {
    configuration.setShuffleTasksForOverloadedAgents(true);
    configuration.setMinutesBeforeNewTaskEligibleForShuffle(15);
    initRequest();
    initFirstDeployWithResources(configuration.getMesosConfiguration().getDefaultCpus(),configuration.getMesosConfiguration().getDefaultMemory());
    saveAndSchedule(requestManager.getRequest(requestId).get().getRequest().toBuilder().setInstances(Optional.of(3)));
    resourceOffers(1);
    SingularityAgentUsage highUsage=new SingularityAgentUsage(15,10,Optional.of(10.0),1,1,Optional.of(30L),1,1,Optional.of(1024L),1,System.currentTimeMillis(),200000,30000,10,15,15,15,0,107374182);
    usageManager.saveCurrentAgentUsage(new SingularityAgentUsageWithId(highUsage,"host1"));
    SingularityTaskId taskId1=taskManager.getActiveTaskIds().get(0);
    String t1=taskId1.getId();
    SingularityTaskId taskId2=taskManager.getActiveTaskIds().get(1);
    String t2=taskId2.getId();
    SingularityTaskId taskId3=taskManager.getActiveTaskIds().get(2);
    String t3=taskId3.getId();
    statusUpdate(taskManager.getTask(taskId1).get(),TaskState.TASK_STARTING,Optional.of(taskId1.getStartedAt()));
    statusUpdate(taskManager.getTask(taskId2).get(),TaskState.TASK_STARTING,Optional.of(taskId2.getStartedAt()));
    statusUpdate(taskManager.getTask(taskId3).get(),TaskState.TASK_STARTING,Optional.of(taskId3.getStartedAt()));
    statusUpdate(taskManager.getTask(taskId2).get(),TaskState.TASK_RUNNING,Optional.of(taskId2.getStartedAt() - TimeUnit.MINUTES.toMillis(15)));
    MesosTaskMonitorObject t1u1=getTaskMonitor(t1,15,TimeUnit.MILLISECONDS.toSeconds(taskId1.getStartedAt()) + 5,1024);
    MesosTaskMonitorObject t2u1=getTaskMonitor(t2,10,TimeUnit.MILLISECONDS.toSeconds(taskId2.getStartedAt()) + 5,1024);
    MesosTaskMonitorObject t3u1=getTaskMonitor(t3,5,TimeUnit.MILLISECONDS.toSeconds(taskId3.getStartedAt()) + 5,1024);
    mesosClient.setAgentResourceUsage("host1",Arrays.asList(t1u1,t2u1,t3u1));
    mesosClient.setAgentMetricsSnapshot("host1",new MesosAgentMetricsSnapshotObject(0,0,0,10.0,0,0,0,0,0,0,0,0,10.0,0,0,0,0,0,0,0,0,0,0,0,0,15,0,0,15,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,15,200000,0,30000,0,0,0,15,0,0,0,0));
    usagePoller.runActionOnPoll();
    Assertions.assertFalse(taskManager.getTaskCleanup(taskId1.getId()).isPresent());
    Assertions.assertFalse(taskManager.getTaskCleanup(taskId3.getId()).isPresent());
    Assertions.assertEquals(TaskCleanupType.REBALANCE_CPU_USAGE,taskManager.getTaskCleanup(taskId2.getId()).get().getCleanupType());
  }
  finally {
    configuration.setShuffleTasksForOverloadedAgents(false);
  }
}
