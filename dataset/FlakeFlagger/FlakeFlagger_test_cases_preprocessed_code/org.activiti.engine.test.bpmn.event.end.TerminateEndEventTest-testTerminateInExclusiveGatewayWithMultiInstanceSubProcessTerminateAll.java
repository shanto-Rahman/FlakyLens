@Deployment public void testTerminateInExclusiveGatewayWithMultiInstanceSubProcessTerminateAll() throws Exception {
assertEquals(5,tasks.size());
assertTrue(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).count() > 0);
assertTrue(runtimeService.createProcessInstanceQuery().processInstanceId(pi.getId()).count() == 0);
}