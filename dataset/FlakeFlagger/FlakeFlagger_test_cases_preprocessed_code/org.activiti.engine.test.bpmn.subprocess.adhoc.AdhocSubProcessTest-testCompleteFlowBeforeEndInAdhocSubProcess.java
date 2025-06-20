@Deployment(resources="org/activiti/engine/test/bpmn/subprocess/adhoc/AdhocSubProcessTest.testFlowsInAdhocSubProcess.bpmn20.xml") public void testCompleteFlowBeforeEndInAdhocSubProcess(){
assertNotNull(execution);
assertEquals(2,enabledActivities.size());
assertEquals("Task in subprocess",subProcessTask.getName());
assertEquals("After task",afterTask.getName());
assertNull(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).singleResult());
}