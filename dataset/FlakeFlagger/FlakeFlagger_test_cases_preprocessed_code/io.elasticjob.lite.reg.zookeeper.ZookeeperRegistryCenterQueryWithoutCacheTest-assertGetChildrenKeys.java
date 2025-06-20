@Test public void assertGetChildrenKeys(){
assertThat(zkRegCenter.getChildrenKeys("/test"),is(Arrays.asList("deep","child")));//RW
assertThat(zkRegCenter.getChildrenKeys("/test/deep"),is(Collections.singletonList("nested")));//RW
assertThat(zkRegCenter.getChildrenKeys("/test/child"),is(Collections.<String>emptyList()));//RW
assertThat(zkRegCenter.getChildrenKeys("/test/notExisted"),is(Collections.<String>emptyList()));//RW
}