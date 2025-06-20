@Test @Deployment public void ruleUsageExample(){
assertEquals("My Task",task.getName());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}