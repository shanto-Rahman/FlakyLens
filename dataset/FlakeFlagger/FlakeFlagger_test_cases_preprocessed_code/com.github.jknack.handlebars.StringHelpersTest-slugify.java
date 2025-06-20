@Test public void slugify() throws IOException {
assertEquals("slugify",slugify.name());
assertEquals("joel-is-a-slug",slugify.apply("  Joel is a slug  ",options));
}