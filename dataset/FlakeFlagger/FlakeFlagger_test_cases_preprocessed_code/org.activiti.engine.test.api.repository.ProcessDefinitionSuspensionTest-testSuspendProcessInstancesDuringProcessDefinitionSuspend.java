@Deployment(resources={"org/activiti/engine/test/api/runtime/oneTaskProcess.bpmn20.xml"}) public void testSuspendProcessInstancesDuringProcessDefinitionSuspend(){
assertEquals(nrOfProcessInstances,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().suspended().count());
assertEquals(nrOfProcessInstances,runtimeService.createProcessInstanceQuery().active().count());
assertTrue(processInstance.isSuspended());
fail("A suspended task shouldn't be able to be continued");
assertEquals(nrOfProcessInstances,runtimeService.createProcessInstanceQuery().count());
assertEquals(nrOfProcessInstances,runtimeService.createProcessInstanceQuery().suspended().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().active().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().suspended().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().active().count());
}