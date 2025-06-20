/** 
 * This test will use the regular mechanism (delegateExecution.getProcessEngine().getRuntimeService()) to obtain the    {@link RuntimeService}  to start a new process.
 */
@Deployment public void testUseRuntimeServiceNotInjectedInServiceTask(){
assertEquals(2,processInstances.size());
if (processDefinition.getKey().equals("startProcessFromDelegate")) {
if (processDefinition.getKey().equals("oneTaskProcess")) {
}
}
assertTrue(startProcessFromDelegateFound);
assertTrue(oneTaskProcessFound);
}