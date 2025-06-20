@Test public void stripTags() throws IOException {
assertEquals("stripTags",stripTags.name());
assertEquals("Joel is a slug",stripTags.apply("<b>Joel</b> <button>is</button> a <span>slug</span>",options));
}