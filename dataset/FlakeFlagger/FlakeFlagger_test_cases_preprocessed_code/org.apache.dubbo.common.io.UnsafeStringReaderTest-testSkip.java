@Test public void testSkip() throws IOException {
assertThat(reader.ready(),is(true));
assertThat(reader.read(),is((int)'b'));
}