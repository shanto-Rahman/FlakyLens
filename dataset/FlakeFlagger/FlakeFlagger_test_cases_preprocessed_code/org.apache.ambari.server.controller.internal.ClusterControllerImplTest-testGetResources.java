@Test public void testGetResources() throws Exception {
Assert.assertEquals(Resource.Type.Host,resource.getType());
Assert.assertEquals(4,cnt);
}