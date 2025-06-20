@Deployment public void testAsyncMethodExpressionOnSpringBean(){
assertTrue(JobTestHelper.areJobsAvailable(managementService));
assertEquals("ACTIVITI BPMN 2.0 PROCESS ENGINE",runtimeService.getVariable(procInst.getId(),"myVar"));
}