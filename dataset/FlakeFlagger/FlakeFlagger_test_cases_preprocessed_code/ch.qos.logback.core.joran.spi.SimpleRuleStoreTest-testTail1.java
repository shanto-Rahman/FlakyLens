@Test public void testTail1() throws Exception {
assertNotNull(r);
assertEquals(1,r.size());
if (!(r.get(0) instanceof XAction)) {
fail("Wrong type");
}
}