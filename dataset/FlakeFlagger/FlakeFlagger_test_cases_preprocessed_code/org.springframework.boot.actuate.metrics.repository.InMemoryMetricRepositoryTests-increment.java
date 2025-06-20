@Test public void increment(){
assertEquals(1.0,this.repository.findOne("foo").getValue().doubleValue(),0.01);
}