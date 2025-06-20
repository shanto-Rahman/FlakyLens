@Test public void testRead() throws IOException {
assertThat(reader.markSupported(),is(true));
assertThat(reader.read(),is((int)'a'));
assertThat(reader.read(),is((int)'b'));
assertThat(reader.read(),is((int)'c'));
assertThat(reader.read(),is(-1));
assertThat(reader.read(),is((int)'a'));
assertThat(chars[0],is('b'));
assertThat(chars[1],is('c'));
}