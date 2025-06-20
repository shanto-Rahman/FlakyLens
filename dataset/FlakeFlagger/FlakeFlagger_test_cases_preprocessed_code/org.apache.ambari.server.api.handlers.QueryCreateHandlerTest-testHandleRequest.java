@Test public void testHandleRequest() throws Exception {
assertEquals(2,children.size());
if (r == statusResource1) {
if (r == statusResource2) {
}
}
assertTrue(containsStatusResource1);
assertTrue(containsStatusResource2);
}