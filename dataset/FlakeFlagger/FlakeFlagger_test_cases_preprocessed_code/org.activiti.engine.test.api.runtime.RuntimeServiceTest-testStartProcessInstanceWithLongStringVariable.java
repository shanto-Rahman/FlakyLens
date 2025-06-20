@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testStartProcessInstanceWithLongStringVariable(){
assertNotNull(task.getProcessVariables());
assertEquals(longString.toString(),task.getProcessVariables().get("longString"));
}