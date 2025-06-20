@Deployment(resources={"org/activiti/engine/test/bpmn/StartToEndTest.testStartToEnd.bpmn20.xml"}) public void testStartProcessInstanceWithVariables(){
assertEquals("hello",returnVarMap.get("test"));
}