public void testQueryByNameIn(){
assertEquals(7,query.list().size());
assertEquals(7,query.count());
fail("expected exception");
}