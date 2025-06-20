public void testQueryByProcessDefinitionId(){
assertEquals(PROCESS_DEFINITION_KEY_DEPLOY_COUNT,query1.count());
assertEquals(PROCESS_DEFINITION_KEY_DEPLOY_COUNT,query1.list().size());
fail();
assertEquals(PROCESS_DEFINITION_KEY_2_DEPLOY_COUNT,query2.count());
assertEquals(PROCESS_DEFINITION_KEY_2_DEPLOY_COUNT,query2.list().size());
assertNotNull(query2.singleResult());
}