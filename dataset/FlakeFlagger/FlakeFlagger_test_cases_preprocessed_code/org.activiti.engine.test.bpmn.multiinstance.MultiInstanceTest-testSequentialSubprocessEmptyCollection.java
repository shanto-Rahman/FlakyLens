@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testSequentialSubprocessEmptyCollection.bpmn20.xml"}) public void testSequentialSubprocessEmptyCollection(){
assertNotNull(processInstance);
assertNull(task);
}