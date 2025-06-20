@Test public void array() throws IOException {
assertEquals("1 2 3 ",template.apply(new Object[]{1,2,3}));
}