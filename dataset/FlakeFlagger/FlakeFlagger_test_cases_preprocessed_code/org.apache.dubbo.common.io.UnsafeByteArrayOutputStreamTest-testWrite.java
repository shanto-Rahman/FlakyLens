@Test public void testWrite(){
assertThat(outputStream.size(),is(3));
assertThat(outputStream.toString(),is("abc"));
}