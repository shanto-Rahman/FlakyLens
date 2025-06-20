public void testQueryByInvalidProcessDefinitionCategory(){
assertNull(query.singleResult());
assertEquals(0,query.list().size());
assertEquals(0,query.count());
}