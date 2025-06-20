@Test public void assertPersist(){
zkRegCenter.persist("/test","test_update");//RW
zkRegCenter.persist("/persist/new","new_value");//RW
assertThat(zkRegCenter.get("/test"),is("test_update"));//RW
assertThat(zkRegCenter.get("/persist/new"),is("new_value"));//RW
}