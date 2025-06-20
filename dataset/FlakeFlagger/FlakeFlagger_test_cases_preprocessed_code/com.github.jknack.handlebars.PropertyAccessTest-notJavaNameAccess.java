@Test public void notJavaNameAccess() throws IOException {
assertEquals("foo",handlebars.compile("{{this.[1foo]}}").apply(context));
assertEquals("foo",handlebars.compile("{{this.['foo']}}").apply(context));
assertEquals("foo",handlebars.compile("{{this.[foo or bar]}}").apply(context));
assertEquals("134",handlebars.compile("{{this.[134]}}").apply(context));
}