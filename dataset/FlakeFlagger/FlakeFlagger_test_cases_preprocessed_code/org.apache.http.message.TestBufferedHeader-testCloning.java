@Test public void testCloning() throws Exception {
Assert.assertEquals(orig.getName(),clone.getName());
Assert.assertEquals(orig.getValue(),clone.getValue());
}