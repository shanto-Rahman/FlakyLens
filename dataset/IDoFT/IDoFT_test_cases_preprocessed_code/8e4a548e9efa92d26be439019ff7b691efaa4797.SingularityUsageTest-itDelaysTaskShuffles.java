@Test public void itDelaysTaskShuffles(){
statusUpdate(taskManager.getTask(taskId2).get(),TaskState.TASK_RUNNING,Optional.of(taskId2.getStartedAt() - TimeUnit.MINUTES.toMillis(15)));
MesosTaskMonitorObject t1u1=getTaskMonitor(t1,15,TimeUnit.MILLISECONDS.toSeconds(taskId1.getStartedAt()) + 5,1024);
MesosTaskMonitorObject t2u1=getTaskMonitor(t2,10,TimeUnit.MILLISECONDS.toSeconds(taskId2.getStartedAt()) + 5,1024);
MesosTaskMonitorObject t3u1=getTaskMonitor(t3,5,TimeUnit.MILLISECONDS.toSeconds(taskId3.getStartedAt()) + 5,1024);
Assertions.assertFalse(taskManager.getTaskCleanup(taskId1.getId()).isPresent());
Assertions.assertFalse(taskManager.getTaskCleanup(taskId3.getId()).isPresent());
Assertions.assertEquals(TaskCleanupType.REBALANCE_CPU_USAGE,taskManager.getTaskCleanup(taskId2.getId()).get().getCleanupType());
}