@Deployment public void testAsyncDelegateExpression() throws Exception {
assertTrue(JobTestHelper.areJobsAvailable(managementService));
Thread.sleep(1000);
assertEquals("Activiti BPMN 2.0 process engine",runtimeService.getVariable(procInst.getId(),"myVar"));
assertEquals("fieldInjectionWorking",runtimeService.getVariable(procInst.getId(),"fieldInjection"));
}