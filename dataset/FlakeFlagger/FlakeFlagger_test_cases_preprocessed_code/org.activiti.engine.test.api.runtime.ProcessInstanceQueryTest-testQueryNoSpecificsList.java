public void testQueryNoSpecificsList(){
assertEquals(PROCESS_DEPLOY_COUNT,query.count());
assertEquals(PROCESS_DEPLOY_COUNT,query.list().size());
}