@Test public void listIndexOutOfBounds() throws IOException {
assertEquals("s2",template.apply(context));
fail("An " + IndexOutOfBoundsException.class.getName() + " is expected.");
assertTrue(ex.getCause() instanceof IndexOutOfBoundsException);
}