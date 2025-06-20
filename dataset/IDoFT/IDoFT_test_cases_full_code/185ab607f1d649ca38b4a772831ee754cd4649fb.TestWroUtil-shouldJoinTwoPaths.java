@Test public void shouldJoinTwoPaths(){
  assertEquals("/a/b/c/d",WroUtil.joinPath("/a/b","c/d"));
  assertEquals("/a/b/c/d",WroUtil.joinPath("/a/b","/c/d"));
  assertEquals("/a/b/c/d",WroUtil.joinPath("/a/b/","c/d"));
  assertEquals("/a/b/c/d",WroUtil.joinPath("/a/b/","/c/d"));
}
