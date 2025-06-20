@Test public void resolveArrayNode() throws IOException {
assertEquals("pojo",handlebars.compile("{{array.[0].key}}").apply(context(root)));
assertEquals("pojo",handlebars.compile("{{#array}}{{key}}{{/array}}").apply(context(root)));
}