@Test public void propertySet() throws IOException {
assertEquals(root.entrySet(),JsonNodeValueResolver.INSTANCE.propertySet(node(root)));
}