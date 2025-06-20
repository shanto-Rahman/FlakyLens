public void testQueryByProcessDefinitionKey(){
assertEquals(1,query.list().size());
assertEquals(1,query.count());
assertNotNull(query.singleResult());
}