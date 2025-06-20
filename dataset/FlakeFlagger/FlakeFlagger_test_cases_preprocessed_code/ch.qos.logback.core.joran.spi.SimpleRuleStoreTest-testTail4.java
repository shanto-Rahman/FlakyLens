@Test public void testTail4() throws Exception {
assertNotNull(r);
assertEquals(1,r.size());
if (!(r.get(0) instanceof ZAction)) {
fail("Wrong type");
}
}