@Test public void testSerialization() throws Exception {
Assert.assertEquals(orig.capacity(),clone.capacity());
Assert.assertEquals(orig.length(),clone.length());
Assert.assertNotNull(data);
Assert.assertEquals(3,data.length);
Assert.assertEquals('a',data[0]);
Assert.assertEquals('b',data[1]);
Assert.assertEquals('c',data[2]);
}