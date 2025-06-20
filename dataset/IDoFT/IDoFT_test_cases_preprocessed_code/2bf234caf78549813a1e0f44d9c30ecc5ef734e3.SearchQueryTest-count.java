@Test public void count(){
assertEquals(1,query().where(filter).fetchCount());
}