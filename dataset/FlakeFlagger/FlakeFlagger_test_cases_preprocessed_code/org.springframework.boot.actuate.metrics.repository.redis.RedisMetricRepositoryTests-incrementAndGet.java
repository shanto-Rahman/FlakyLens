@Test public void incrementAndGet(){
assertEquals(3,this.repository.findOne("foo").getValue().longValue());
}