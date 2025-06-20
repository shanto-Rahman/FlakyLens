@Test public void wordWrap() throws IOException {
assertEquals("wordWrap",wordWrap.name());
assertEquals("Joel" + SystemUtils.LINE_SEPARATOR + "is a"+ SystemUtils.LINE_SEPARATOR+ "slug",wordWrap.apply("Joel is a slug",options));
}