@Test @Deployment public void testSubProcessEvents(){
assertEquals(2,events.size());
assertEquals("subProcess",event.getActivityType());
assertEquals(subProcessExecution.getId(),event.getExecutionId());
assertEquals("subProcess",event.getActivityType());
assertEquals(subProcessExecution.getId(),event.getExecutionId());
}