@Test public void shouldGetASMVersion(){
assertThat(version.getVersion(),Matchers.anyOf(startsWith("5."),startsWith("6."),startsWith("7.")));
}