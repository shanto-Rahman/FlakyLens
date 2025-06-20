@Test @Deployment public void simpleProcessTest(){
assertEquals("My Task",task.getName());
assertNotNull(activitiSpringRule.getRuntimeService());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}