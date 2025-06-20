@Test public void resolveValueNode() throws IOException {
assertEquals("abc 678 6789 7.13 3.14 true",handlebars.compile("{{string}} {{int}} {{long}} {{float}} {{double}} {{bool}}").apply(context(root)));
}