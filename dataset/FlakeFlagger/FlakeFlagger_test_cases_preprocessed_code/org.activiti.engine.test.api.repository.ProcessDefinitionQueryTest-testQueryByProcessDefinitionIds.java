public void testQueryByProcessDefinitionIds(){
assertEquals(queryResults.size(),ids.size());
assertTrue(ids.contains(processDefinition.getId()));
}