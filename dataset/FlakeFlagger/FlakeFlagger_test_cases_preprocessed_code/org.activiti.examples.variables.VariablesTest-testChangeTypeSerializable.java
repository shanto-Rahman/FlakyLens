@Deployment(resources={"org/activiti/examples/variables/VariablesTest.testChangeTypeSerializable.bpmn20.xml"}) public void testChangeTypeSerializable(){
assertNotNull(processInstance);
assertEquals("Activiti is awesome!",task.getName());
assertEquals("someValue",myVar.getValue());
}