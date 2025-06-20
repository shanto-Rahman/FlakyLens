@Deployment(resources="org/activiti/engine/test/api/runtime/ProcessInstanceSuspensionTest.testSignalEventReceivedAfterProcessInstanceSuspended.bpmn20.xml") public void testSignalEventReceivedAfterMultipleProcessInstancesSuspended(){
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(2,runtimeService.createProcessInstanceQuery().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().count());
}