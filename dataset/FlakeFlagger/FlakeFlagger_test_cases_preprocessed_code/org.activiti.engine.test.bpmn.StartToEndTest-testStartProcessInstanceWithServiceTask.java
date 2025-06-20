@Deployment(resources={"org/activiti/engine/test/bpmn/StartToEndTest.testStartWithServiceTask.bpmn20.xml"}) public void testStartProcessInstanceWithServiceTask(){
assertEquals("hello",returnVarMap.get("test"));
assertEquals("string",returnVarMap.get("string"));
assertEquals(true,returnVarMap.get("boolean"));
assertEquals(25.5,returnVarMap.get("double"));
assertEquals(10L,returnVarMap.get("long"));
}