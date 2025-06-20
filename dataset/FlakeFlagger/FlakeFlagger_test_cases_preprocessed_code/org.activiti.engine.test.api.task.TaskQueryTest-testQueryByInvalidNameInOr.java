public void testQueryByInvalidNameInOr(){
assertEquals(0,query.list().size());
assertEquals(0,query.count());
fail("expected exception");
}