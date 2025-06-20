@Test public void testRead() throws IOException {
assertThat(stream.read(),is((int)'a'));
assertThat(stream.available(),is(2));
assertThat(stream.available(),is(1));
assertThat(read,is(1));
assertThat(bytes,is("c".getBytes()));
assertThat(stream.position(),is(0));
assertThat(stream.size(),is(3));
assertThat(stream.read(),is((int)'b'));
}