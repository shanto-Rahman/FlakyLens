@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testSequentialEmptyCollection.bpmn20.xml"}) public void testSequentialEmptyCollection(){
assertNotNull(processInstance);
assertNull(task);
}