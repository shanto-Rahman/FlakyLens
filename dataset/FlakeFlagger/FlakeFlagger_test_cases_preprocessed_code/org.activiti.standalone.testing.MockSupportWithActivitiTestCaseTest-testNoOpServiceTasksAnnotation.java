@Deployment @NoOpServiceTasks public void testNoOpServiceTasksAnnotation(){
assertEquals(0,mockSupport().getNrOfNoOpServiceTaskExecutions());
assertEquals(5,mockSupport().getNrOfNoOpServiceTaskExecutions());
assertEquals("com.yourcompany.delegate" + i,mockSupport().getExecutedNoOpServiceTaskDelegateClassNames().get(i - 1));
}