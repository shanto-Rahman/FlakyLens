@Test public void testWrapperObject() throws Exception {
Assert.assertTrue(w.getMethodNames().length == 4);
Assert.assertTrue(w.getPropertyNames().length == 0);
Assert.assertEquals(null,w.getPropertyType(null));
}