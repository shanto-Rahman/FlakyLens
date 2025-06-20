@Test public void assertGetFromServer(){
assertThat(zkRegCenter.get("/test"),is("test"));//RW
assertThat(zkRegCenter.get("/test/deep/nested"),is("deepNested"));//RW
}