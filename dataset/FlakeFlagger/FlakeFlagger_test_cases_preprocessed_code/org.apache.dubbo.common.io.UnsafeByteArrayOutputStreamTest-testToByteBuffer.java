@Test public void testToByteBuffer(){
assertThat(byteBuffer.get(),is("a".getBytes()[0]));
}