@Deployment public void testChangingCollection(){
assertNotNull(instance);
assertEquals("multi",task.getTaskDefinitionKey());
assertEquals(0,instances.size());
}