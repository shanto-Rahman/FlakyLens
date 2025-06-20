@Deployment(resources={"org/activiti/standalone/testing/MockSupportWithActivitiTestCaseTest.testNoOpServiceTasksAnnotation.bpmn20.xml"}) @NoOpServiceTasks(ids={"serviceTask1","serviceTask3","serviceTask5"},classNames={"com.yourcompany.delegate2","com.yourcompany.delegate4"}) public void testNoOpServiceTasksWithIdsAnnotation(){
assertEquals(0,mockSupport().getNrOfNoOpServiceTaskExecutions());
assertEquals(5,mockSupport().getNrOfNoOpServiceTaskExecutions());
assertEquals("com.yourcompany.delegate" + i,mockSupport().getExecutedNoOpServiceTaskDelegateClassNames().get(i - 1));
}