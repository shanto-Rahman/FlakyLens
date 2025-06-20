@Test public void writeAndRead(){
assertEquals(2L,this.repository.findOne("foo").getCount());
assertEquals(2d,this.repository.findOne("foo").getValue(),0.01);
}