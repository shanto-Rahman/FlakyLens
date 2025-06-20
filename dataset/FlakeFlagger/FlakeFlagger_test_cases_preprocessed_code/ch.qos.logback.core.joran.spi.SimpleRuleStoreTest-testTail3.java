@Test public void testTail3() throws Exception {
assertNotNull(r);
assertEquals(1,r.size());
if (!(r.get(0) instanceof YAction)) {
fail("Wrong type");
}
}