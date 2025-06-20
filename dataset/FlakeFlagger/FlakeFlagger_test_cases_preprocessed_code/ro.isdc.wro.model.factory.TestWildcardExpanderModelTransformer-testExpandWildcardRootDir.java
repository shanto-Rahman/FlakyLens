@Test public void testExpandWildcardRootDir() throws Exception {
Assert.assertEquals(2,group.getResources().size());
Assert.assertEquals("/js1.js",group.getResources().get(0).getUri());
Assert.assertEquals("/js2.js",group.getResources().get(1).getUri());
}