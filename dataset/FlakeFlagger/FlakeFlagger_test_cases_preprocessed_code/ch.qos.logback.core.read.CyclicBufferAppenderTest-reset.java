@Test public void reset(){
assertEquals(1,cyclicBufferAppender.getLength());
assertEquals(0,cyclicBufferAppender.getLength());
}