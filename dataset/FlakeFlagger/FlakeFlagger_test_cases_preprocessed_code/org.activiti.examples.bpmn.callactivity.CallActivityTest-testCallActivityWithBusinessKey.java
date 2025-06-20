@Deployment(resources={"org/activiti/examples/bpmn/callactivity/mainProcess.bpmn20.xml","org/activiti/examples/bpmn/callactivity/childProcess.bpmn20.xml","org/activiti/examples/bpmn/callactivity/mainProcessBusinessKey.bpmn20.xml","org/activiti/examples/bpmn/callactivity/mainProcessInheritBusinessKey.bpmn20.xml"}) public void testCallActivityWithBusinessKey(){
assertNull(subProcessInstance.getBusinessKey());
assertEquals("123",subProcessInstance.getBusinessKey());
assertEquals("123",subProcessInstance.getBusinessKey());
}