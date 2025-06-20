@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testMultipleProcessesStarted(){
assertEquals(20,tasks.size());
}