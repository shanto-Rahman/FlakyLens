@Deployment(resources={"org/activiti/engine/test/api/runtime/superProcess.bpmn20.xml","org/activiti/engine/test/api/runtime/subProcess.bpmn20.xml"}) public void testQueryBySuperProcessInstanceId(){
assertNotNull(subProcessInstance);
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}