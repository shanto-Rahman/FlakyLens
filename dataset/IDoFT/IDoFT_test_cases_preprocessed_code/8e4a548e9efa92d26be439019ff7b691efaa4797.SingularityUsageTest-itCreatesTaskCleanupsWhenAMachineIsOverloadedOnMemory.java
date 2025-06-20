@Test public void itCreatesTaskCleanupsWhenAMachineIsOverloadedOnMemory(){
MesosTaskMonitorObject t1u1=getTaskMonitor(t1,2,TimeUnit.MILLISECONDS.toSeconds(taskId1.getStartedAt()) + 5,95000);
MesosTaskMonitorObject t2u1=getTaskMonitor(t2,5,TimeUnit.MILLISECONDS.toSeconds(taskId2.getStartedAt()) + 5,63333);
MesosTaskMonitorObject t3u1=getTaskMonitor(t3,5,TimeUnit.MILLISECONDS.toSeconds(taskId3.getStartedAt()) + 5,31667);
Assertions.assertFalse(taskManager.getTaskCleanup(taskId1.getId()).isPresent());
Assertions.assertEquals(TaskCleanupType.REBALANCE_MEMORY_USAGE,taskManager.getTaskCleanup(taskId3.getId()).get().getCleanupType());
Assertions.assertFalse(taskManager.getTaskCleanup(taskId2.getId()).isPresent());
}