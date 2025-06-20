@Test public void testAppendLines() throws Exception {
assertThat(lines.length,equalTo(3));
assertThat(lines[0],equalTo("a"));
assertThat(lines[1],equalTo("b"));
assertThat(lines[2],equalTo("c"));
}