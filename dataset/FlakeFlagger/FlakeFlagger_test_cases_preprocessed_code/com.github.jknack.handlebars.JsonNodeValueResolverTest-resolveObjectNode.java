@Test public void resolveObjectNode() throws IOException {
assertEquals("pojo",handlebars.compile("{{pojo.key}}").apply(context(root)));
}