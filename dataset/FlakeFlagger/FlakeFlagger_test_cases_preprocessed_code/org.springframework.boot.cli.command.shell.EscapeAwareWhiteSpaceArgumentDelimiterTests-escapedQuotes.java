@Test public void escapedQuotes() throws Exception {
assertThat(argumentList.getArguments(),equalTo(new String[]{"\\'a","b"}));
assertThat(this.delimiter.parseArguments(s),equalTo(new String[]{"'a","b"}));
}