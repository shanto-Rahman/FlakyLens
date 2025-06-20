@Deployment(resources={"org/activiti/engine/test/bpmn/callactivity/CallActivity.testTwoSubProcesses.bpmn20.xml","org/activiti/engine/test/bpmn/callactivity/simpleSubProcess.bpmn20.xml"}) public void testTwoSubProcesses(){
assertNotNull(instanceList);
assertEquals(3,instanceList.size());
assertNotNull(taskList);
assertEquals(2,taskList.size());
assertNotNull(instanceList);
assertEquals(0,instanceList.size());
assertNotNull(taskList);
assertEquals(0,taskList.size());
}