public void testQueryByKey(){
assertNotNull(model);
assertEquals(1,query.list().size());
assertEquals(1,query.count());
}