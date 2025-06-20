public void testQueryByNameOr(){
assertEquals(6,query.list().size());
assertEquals(6,query.count());
fail("expected exception");
}