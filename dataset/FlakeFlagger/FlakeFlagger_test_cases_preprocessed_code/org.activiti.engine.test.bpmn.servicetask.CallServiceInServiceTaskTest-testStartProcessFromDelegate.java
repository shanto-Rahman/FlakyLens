@Deployment public void testStartProcessFromDelegate(){
assertEquals(2,processInstances.size());
if (processDefinition.getKey().equals("startProcessFromDelegate")) {
if (processDefinition.getKey().equals("oneTaskProcess")) {
}
}
assertTrue(startProcessFromDelegateFound);
assertTrue(oneTaskProcessFound);
}