public void testProcessDefinitionGraphicalNotationFlag(){
assertEquals(2,repositoryService.createProcessDefinitionQuery().count());
assertTrue(processWithDi.hasGraphicalNotation());
assertFalse(processWithoutDi.hasGraphicalNotation());
}