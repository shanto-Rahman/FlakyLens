@Test public void testBasicWrite() throws Exception {
Assert.assertNotNull(input);
Assert.assertEquals(expected.length,input.length);
Assert.assertEquals(expected[i],input[i]);
}