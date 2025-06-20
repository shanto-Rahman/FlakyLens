@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testSequentialEmptyCollection.bpmn20.xml"}) public void testSequentialEmptyCollectionWithNonEmptyCollection(){
assertNotNull(processInstance);
assertNotNull(task);
}