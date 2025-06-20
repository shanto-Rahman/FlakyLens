@Test @Deployment(resources={"org/activiti/standalone/testing/MockSupportWithActivitiRuleTest.testNoOpServiceTasksAnnotation.bpmn20.xml"}) @NoOpServiceTasks(ids={"serviceTask1","serviceTask3","serviceTask5"},classNames={"com.yourcompany.delegate2","com.yourcompany.delegate4"}) public void testNoOpServiceTasksWithIdsAnnotation(){
Assert.assertEquals(0,mockSupport.getNrOfNoOpServiceTaskExecutions());
Assert.assertEquals(5,mockSupport.getNrOfNoOpServiceTaskExecutions());
Assert.assertEquals("com.yourcompany.delegate" + i,mockSupport.getExecutedNoOpServiceTaskDelegateClassNames().get(i - 1));
}