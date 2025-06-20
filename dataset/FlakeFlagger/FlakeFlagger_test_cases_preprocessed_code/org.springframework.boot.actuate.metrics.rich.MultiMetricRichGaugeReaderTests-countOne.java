@Test public void countOne(){
assertEquals(6,this.repository.count());
assertEquals(1,this.reader.count());
assertNotNull(one);
assertEquals(2,one.getCount());
}