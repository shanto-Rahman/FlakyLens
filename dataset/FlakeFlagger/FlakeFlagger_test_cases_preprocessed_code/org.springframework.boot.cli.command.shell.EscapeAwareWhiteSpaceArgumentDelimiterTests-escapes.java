@Test public void escapes() throws Exception {
assertThat(this.delimiter.parseArguments(s),equalTo(new String[]{" \\.\\\t"}));
}