/** 
 * This test will use the dependency injection of Spring to inject the runtime service in the Java delegate.
 */
@Deployment public void testUseInjectedRuntimeServiceInServiceTask(){
assertEquals(2,processInstances.size());
if (processDefinition.getKey().equals("startProcessFromDelegate")) {
if (processDefinition.getKey().equals("oneTaskProcess")) {
}
}
assertTrue(startProcessFromDelegateFound);
assertTrue(oneTaskProcessFound);
}