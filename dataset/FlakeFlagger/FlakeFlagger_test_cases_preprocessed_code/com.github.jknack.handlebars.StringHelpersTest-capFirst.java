@Test public void capFirst() throws IOException {
assertEquals("capitalizeFirst",capitalizeFirst.name());
assertEquals("Handlebars.java",capitalizeFirst.apply("handlebars.java",options));
}