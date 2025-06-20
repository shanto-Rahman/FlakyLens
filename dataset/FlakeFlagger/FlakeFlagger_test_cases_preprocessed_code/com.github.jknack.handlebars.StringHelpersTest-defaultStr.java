@Test public void defaultStr() throws IOException {
assertEquals("defaultIfEmpty",defaultIfEmpty.name());
assertEquals("handlebars.java",defaultIfEmpty.apply(null,options));
assertEquals("handlebars.java",defaultIfEmpty.apply(false,options));
assertEquals("handlebars.java",defaultIfEmpty.apply(Collections.emptyList(),options));
assertEquals("something",defaultIfEmpty.apply("something",options));
}