@Test public void decrementPrependsCounter(){
assertEquals("counter.foo",this.captor.getValue().getName());
assertEquals(-1L,this.captor.getValue().getValue());
}