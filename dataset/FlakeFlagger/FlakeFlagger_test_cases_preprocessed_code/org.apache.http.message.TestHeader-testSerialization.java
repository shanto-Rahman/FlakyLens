@Test public void testSerialization() throws Exception {
Assert.assertEquals(orig.getName(),clone.getName());
Assert.assertEquals(orig.getValue(),clone.getValue());
}