@Deployment(resources={"org/activiti/engine/test/api/runtime/superProcessWithMultipleNestedSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/nestedSubProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/subProcess.bpmn20.xml"}) public void testQueryForActiveAndSuspendedProcessInstances(){
assertEquals(5,runtimeService.createProcessInstanceQuery().count());
assertEquals(5,runtimeService.createProcessInstanceQuery().active().count());
assertEquals(0,runtimeService.createProcessInstanceQuery().suspended().count());
assertEquals(5,runtimeService.createProcessInstanceQuery().count());
assertEquals(4,runtimeService.createProcessInstanceQuery().active().count());
assertEquals(1,runtimeService.createProcessInstanceQuery().suspended().count());
assertEquals(piToSuspend.getId(),runtimeService.createProcessInstanceQuery().suspended().singleResult().getId());
}