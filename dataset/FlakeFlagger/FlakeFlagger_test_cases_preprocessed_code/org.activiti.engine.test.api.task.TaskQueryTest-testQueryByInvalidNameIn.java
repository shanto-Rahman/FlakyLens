public void testQueryByInvalidNameIn(){
assertEquals(0,query.list().size());
assertEquals(0,query.count());
fail("expected exception");
}