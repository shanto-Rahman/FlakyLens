@Test public void smokeII() throws Exception {
assertNotNull(r);
assertEquals(2,r.size());
if (!(r.get(0) instanceof XAction)) {
fail("Wrong type");
}
if (!(r.get(1) instanceof YAction)) {
fail("Wrong type");
}
}