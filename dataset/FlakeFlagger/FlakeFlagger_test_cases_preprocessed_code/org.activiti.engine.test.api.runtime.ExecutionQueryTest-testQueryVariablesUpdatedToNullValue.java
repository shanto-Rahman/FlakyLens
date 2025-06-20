@Deployment(resources={"org/activiti/engine/test/api/oneTaskProcess.bpmn20.xml"}) public void testQueryVariablesUpdatedToNullValue(){
assertNull(query.singleResult());
assertNotNull(notQuery.singleResult());
assertNotNull(queryResult);
assertEquals(processInstance.getId(),queryResult.getId());
assertNull(notQuery.singleResult());
}