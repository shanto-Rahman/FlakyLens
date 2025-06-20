@Test public void set(){
assertEquals(2.5,this.repository.findOne("foo").getValue().doubleValue(),0.01);
}