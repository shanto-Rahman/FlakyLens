@Test public void renderWithReplacement() throws Exception {
assertThat(out.toString(),startsWith("banner 1"));
assertThat(out.toString(),not(containsString("$")));
}