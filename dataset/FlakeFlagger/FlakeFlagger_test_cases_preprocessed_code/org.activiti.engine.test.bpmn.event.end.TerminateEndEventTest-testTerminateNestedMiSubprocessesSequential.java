@Deployment public void testTerminateNestedMiSubprocessesSequential(){
assertNotNull("Task was null for i = " + i,task);
assertNotNull(taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskName("I").singleResult());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskName("D").count());
assertEquals(1,taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskName("F").count());
assertNotNull(taskService.createTaskQuery().processInstanceId(processInstance.getId()).taskName("H").singleResult());
}