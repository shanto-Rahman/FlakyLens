public void testQueryByUnassigned(){
assertEquals(11,query.count());
assertEquals(11,query.list().size());
}