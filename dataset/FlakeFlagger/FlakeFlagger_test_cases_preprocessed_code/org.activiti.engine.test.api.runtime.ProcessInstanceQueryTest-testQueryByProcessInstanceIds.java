public void testQueryByProcessInstanceIds(){
assertEquals(5,processInstanceQuery.count());
assertNotNull(processInstances);
assertEquals(5,processInstances.size());
assertTrue(processInstanceIds.contains(processInstance.getId()));
}