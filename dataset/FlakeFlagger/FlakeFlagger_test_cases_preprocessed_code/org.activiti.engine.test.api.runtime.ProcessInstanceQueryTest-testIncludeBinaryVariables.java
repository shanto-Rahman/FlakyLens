@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testIncludeBinaryVariables() throws Exception {
assertNotNull(processInstance);
assertEquals("It is I, le binary",new String(bytes));
}