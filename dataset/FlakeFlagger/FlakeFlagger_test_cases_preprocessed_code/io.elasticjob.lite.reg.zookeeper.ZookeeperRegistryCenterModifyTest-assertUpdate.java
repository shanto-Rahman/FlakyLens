@Test public void assertUpdate(){
zkRegCenter.persist("/update","before_update");//RW
zkRegCenter.update("/update","after_update");//RW
assertThat(zkRegCenter.getDirectly("/update"),is("after_update"));//RW
}