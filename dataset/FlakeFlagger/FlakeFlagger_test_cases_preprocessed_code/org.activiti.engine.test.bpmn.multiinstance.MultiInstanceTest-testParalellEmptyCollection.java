@Deployment(resources={"org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testParallelEmptyCollection.bpmn20.xml"}) public void testParalellEmptyCollection() throws Exception {
assertNotNull(processInstance);
assertNull(task);
}