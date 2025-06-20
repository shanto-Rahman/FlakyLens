@Test public void incrementPrependsCounter(){
assertEquals("counter.foo",this.captor.getValue().getName());
assertEquals(1L,this.captor.getValue().getValue());
}