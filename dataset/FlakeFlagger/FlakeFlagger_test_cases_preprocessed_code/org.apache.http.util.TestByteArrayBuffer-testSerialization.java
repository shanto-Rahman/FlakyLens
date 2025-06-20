@Test public void testSerialization() throws Exception {
Assert.assertEquals(orig.capacity(),clone.capacity());
Assert.assertEquals(orig.length(),clone.length());
Assert.assertNotNull(data);
Assert.assertEquals(3,data.length);
Assert.assertEquals(1,data[0]);
Assert.assertEquals(2,data[1]);
Assert.assertEquals(3,data[2]);
}