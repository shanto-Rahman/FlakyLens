@Test public void shouldProcessValidCss() throws IOException {
  assertEquals("#element {\n  color: red; }\n",engine.process("#element {color: red;}"));
}
