@Test public void getByteBufferState(){
assertEquals(3,dst.position());
assertEquals(3,dst.limit());
assertEquals(0,dst.get(0));
assertEquals(2,dst.get(1));
assertEquals(3,dst.get(2));
assertEquals(0,dst.get(3));
}