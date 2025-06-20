@Deployment public void testAsyncBehavior(){
assertEquals(0,runtimeService.createProcessInstanceQuery().processInstanceId(processInstance.getId()).count());
}