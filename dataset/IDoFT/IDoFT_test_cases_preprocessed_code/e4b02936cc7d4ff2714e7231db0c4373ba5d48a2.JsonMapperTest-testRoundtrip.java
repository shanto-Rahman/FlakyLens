@Test public void testRoundtrip() throws IOException {
Assert.assertNotNull(json);
Assert.assertEquals(JSON_SOURCE,json);
Assert.assertNotNull(cloned);
Assert.assertEquals(source,cloned);
}