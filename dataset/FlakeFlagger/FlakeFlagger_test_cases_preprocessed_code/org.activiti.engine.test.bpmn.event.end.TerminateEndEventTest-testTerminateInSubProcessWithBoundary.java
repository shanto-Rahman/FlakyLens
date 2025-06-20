@Deployment public void testTerminateInSubProcessWithBoundary() throws Exception {
assertEquals(3,taskService.createTaskQuery().processInstanceId(pi.getId()).count());
assertEquals(0L,managementService.createJobQuery().count());
assertEquals(3,taskService.createTaskQuery().processInstanceId(pi.getId()).count());
assertEquals(1L,managementService.createTimerJobQuery().count());
assertEquals(1,taskService.createTaskQuery().processInstanceId(pi.getId()).count());
assertEquals(0L,managementService.createTimerJobQuery().count());
}