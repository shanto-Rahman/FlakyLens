@Test public void assertGetNumChildren(){
assertThat(zkRegCenter.getNumChildren("/test"),is(2));//RW
assertThat(zkRegCenter.getNumChildren("/test/deep"),is(1));//RW
assertThat(zkRegCenter.getNumChildren("/test/child"),is(0));//RW
assertThat(zkRegCenter.getNumChildren("/test/notExisted"),is(0));//RW
}