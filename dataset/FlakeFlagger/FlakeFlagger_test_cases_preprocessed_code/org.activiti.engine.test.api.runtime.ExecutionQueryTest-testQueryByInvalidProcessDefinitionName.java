public void testQueryByInvalidProcessDefinitionName(){
assertNull(query.singleResult());
assertEquals(0,query.list().size());
assertEquals(0,query.count());
}