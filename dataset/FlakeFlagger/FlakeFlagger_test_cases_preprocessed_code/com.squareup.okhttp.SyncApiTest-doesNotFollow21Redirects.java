@Test public void doesNotFollow21Redirects() throws Exception {
fail();
assertEquals("Too many redirects: 21",e.getMessage());
}