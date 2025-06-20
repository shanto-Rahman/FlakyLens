@Test public void testGetResourcesWithPredicate() throws Exception {
Assert.assertEquals(Resource.Type.Host,resource.getType());
Assert.assertEquals(2,cnt);
}