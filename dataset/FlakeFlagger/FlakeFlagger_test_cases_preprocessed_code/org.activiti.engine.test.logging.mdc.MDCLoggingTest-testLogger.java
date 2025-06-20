@Deployment public void testLogger(){
fail("Expected exception");
assertTrue(messages.contains("ProcessDefinitionId=" + TestService.processDefinitionId));
assertTrue(messages.contains("executionId=" + TestService.executionId));
assertTrue(messages.contains("mdcProcessInstanceID=" + TestService.processInstanceId));
assertTrue(messages.contains("mdcBusinessKey=" + (TestService.businessKey == null ? "" : TestService.businessKey)));
fail("Expected exception");
assertFalse(console.toString().contains("ProcessDefinitionId=" + TestService.processDefinitionId));
}