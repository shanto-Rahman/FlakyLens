public void testQueryByProcessDefinitionKeySingleResult(){
assertEquals(PROCESS_DEFINITION_KEY_2_DEPLOY_COUNT,query.count());
assertEquals(PROCESS_DEFINITION_KEY_2_DEPLOY_COUNT,query.list().size());
assertNotNull(query.singleResult());
}