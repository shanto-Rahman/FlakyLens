public void testDeployIdenticalProcessDefinitions(){
assertNotNull(processDefinitions);
assertEquals(2,processDefinitions.size());
assertEquals("IDR",processDefinition.getKey());
assertEquals("Insurance Damage Report",processDefinition.getName());
assertTrue(processDefinition.getId().startsWith("IDR:2"));
assertEquals(2,processDefinition.getVersion());
assertEquals("IDR",processDefinition.getKey());
assertEquals("Insurance Damage Report",processDefinition.getName());
assertTrue(processDefinition.getId().startsWith("IDR:1"));
assertEquals(1,processDefinition.getVersion());
}