@Test public void testGetResourcesEmptyRequest() throws Exception {
Assert.assertEquals(Resource.Type.Host,resource.getType());
Assert.assertEquals(4,cnt);
}