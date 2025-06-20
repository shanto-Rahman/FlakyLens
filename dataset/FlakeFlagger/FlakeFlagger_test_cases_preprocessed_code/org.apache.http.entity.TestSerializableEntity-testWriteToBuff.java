@Test public void testWriteToBuff() throws Exception {
Assert.assertNotNull(bytes);
Assert.assertEquals(4,serIn.intValue);
Assert.assertEquals("Hello",serIn.stringValue);
Assert.fail("IllegalArgumentException should have been thrown");
}