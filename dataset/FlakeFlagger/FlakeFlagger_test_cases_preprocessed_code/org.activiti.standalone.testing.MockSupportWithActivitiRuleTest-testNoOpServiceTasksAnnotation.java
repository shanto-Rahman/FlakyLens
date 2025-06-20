@Test @Deployment @NoOpServiceTasks public void testNoOpServiceTasksAnnotation(){
Assert.assertEquals(0,activitiRule.mockSupport().getNrOfNoOpServiceTaskExecutions());
Assert.assertEquals(5,activitiRule.mockSupport().getNrOfNoOpServiceTaskExecutions());
Assert.assertEquals("com.yourcompany.delegate" + i,activitiRule.mockSupport().getExecutedNoOpServiceTaskDelegateClassNames().get(i - 1));
}