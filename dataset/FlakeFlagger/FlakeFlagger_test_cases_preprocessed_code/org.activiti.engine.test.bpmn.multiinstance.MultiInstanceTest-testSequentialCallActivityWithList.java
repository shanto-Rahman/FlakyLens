@Deployment(resources="org/activiti/engine/test/bpmn/multiinstance/MultiInstanceTest.testSequentialCallActivityWithList.bpmn20.xml") public void testSequentialCallActivityWithList(){
assertNotNull(task1);
assertNotNull(task2);
assertNotNull(task3);
assertNotNull(task4);
}