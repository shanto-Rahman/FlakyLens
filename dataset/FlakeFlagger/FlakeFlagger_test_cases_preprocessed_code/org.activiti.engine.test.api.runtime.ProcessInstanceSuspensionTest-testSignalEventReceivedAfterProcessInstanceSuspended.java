@Deployment public void testSignalEventReceivedAfterProcessInstanceSuspended(){
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
}