@Test public void testSkipZero(){
assertThat(skip,is(0L));
assertThat(stream.position(),is(0));
}