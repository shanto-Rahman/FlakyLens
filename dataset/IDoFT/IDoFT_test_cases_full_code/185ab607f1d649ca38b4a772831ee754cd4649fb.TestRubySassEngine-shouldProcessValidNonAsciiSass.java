@Test public void shouldProcessValidNonAsciiSass() throws IOException {
  assertEquals("@charset \"UTF-8\";\n#element {\n  font-family: \"\uFF2D\uFF33 \uFF30\u30B4\u30B7\u30C3\u30AF\"; }\n",engine.process("#element {font-family: \"\uFF2D\uFF33 \uFF30\u30B4\u30B7\u30C3\u30AF\";}"));
}
