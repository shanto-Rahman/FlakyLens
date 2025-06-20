@Test public void testMark(){
assertThat(stream.markSupported(),is(true));
assertThat(stream.position(),is(2));
assertThat(stream.position(),is(1));
}