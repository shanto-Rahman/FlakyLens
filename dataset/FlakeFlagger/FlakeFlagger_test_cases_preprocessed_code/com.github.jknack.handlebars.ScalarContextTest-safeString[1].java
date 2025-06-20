@Test public void safeString() throws IOException {
assertEquals("var s = '<div>';",template.apply(new Handlebars.SafeString("<div>")));
}