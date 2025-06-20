@Test public void arrayIndexOutOfBounds() throws IOException {
assertEquals("s2",template.apply(context));
fail("An " + ArrayIndexOutOfBoundsException.class.getName() + " is expected.");
assertTrue(ex.getCause() instanceof ArrayIndexOutOfBoundsException);
}