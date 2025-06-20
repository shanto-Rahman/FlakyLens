@Test public void testHasMethod() throws Exception {
Assert.assertTrue(w.hasMethod("setName"));
Assert.assertTrue(w.hasMethod("hello"));
Assert.assertTrue(w.hasMethod("showInt"));
Assert.assertTrue(w.hasMethod("getFloat"));
Assert.assertTrue(w.hasMethod("setFloat"));
Assert.assertFalse(w.hasMethod("setFloatXXX"));
}