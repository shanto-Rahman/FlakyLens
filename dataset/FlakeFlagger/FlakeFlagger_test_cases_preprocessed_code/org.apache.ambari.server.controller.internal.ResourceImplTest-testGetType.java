@Test public void testGetType(){
Assert.assertEquals(Resource.Type.Cluster,resource.getType());
Assert.assertEquals(Resource.Type.Service,resource.getType());
Assert.assertEquals(Resource.Type.Host,resource.getType());
Assert.assertEquals(Resource.Type.Component,resource.getType());
Assert.assertEquals(Resource.Type.HostComponent,resource.getType());
}