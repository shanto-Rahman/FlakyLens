public void testSignalStartEventFromAPIAsync(){
assertEquals(3,managementService.createJobQuery().count());
assertEquals(3,runtimeService.createProcessInstanceQuery().count());
assertEquals(3,taskService.createTaskQuery().count());
assertEquals("Task in process " + names.get(i),tasks.get(i).getName());
assertEquals(4,runtimeService.createProcessInstanceQuery().count());
assertEquals(4,taskService.createTaskQuery().count());
assertEquals(1,taskService.createTaskQuery().taskName("Task in process D").count());
assertEquals(4,managementService.createJobQuery().count());
assertEquals(7,runtimeService.createProcessInstanceQuery().count());
assertEquals(7,taskService.createTaskQuery().count());
assertEquals(1,taskService.createTaskQuery().taskName("Task after signal").count());
}