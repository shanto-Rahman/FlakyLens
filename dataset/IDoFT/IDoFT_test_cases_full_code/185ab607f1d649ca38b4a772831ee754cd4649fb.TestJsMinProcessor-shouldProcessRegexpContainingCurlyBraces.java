@Test public void shouldProcessRegexpContainingCurlyBraces() throws Exception {
  assertEquals("\nreturn/\\d{1,2}[\\/\\-]\\d{1,2}[\\/\\-]\\d{2,4}/.test(s);",jsmin("return /\\d{1,2}[\\/\\-]\\d{1,2}[\\/\\-]\\d{2,4}/.test(s);"));
}
