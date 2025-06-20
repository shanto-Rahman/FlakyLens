@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelEmptyCollection.bpmn20.xml"}) public void testParalellEmptyCollectionWithNonEmptyCollection(){
assertNotNull(processInstance);
assertNotNull(task);
}