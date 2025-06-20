@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testTaskQueryAfterProcessInstanceSuspend(){
assertNotNull(task);
assertNotNull(task);
assertEquals(1,taskService.createTaskQuery().count());
assertEquals(1,taskService.createTaskQuery().suspended().count());
assertEquals(0,taskService.createTaskQuery().active().count());
assertEquals(1,taskService.createTaskQuery().count());
assertEquals(0,taskService.createTaskQuery().suspended().count());
assertEquals(1,taskService.createTaskQuery().active().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}