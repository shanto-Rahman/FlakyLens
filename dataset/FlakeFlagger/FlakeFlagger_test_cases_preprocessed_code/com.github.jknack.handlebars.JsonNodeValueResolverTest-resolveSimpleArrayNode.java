@Test public void resolveSimpleArrayNode() throws IOException {
assertEquals("123",handlebars.compile("{{array.[0]}}{{array.[1]}}{{array.[2]}}").apply(context(root)));
assertEquals("123",handlebars.compile("{{#array}}{{this}}{{/array}}").apply(context(root)));
}