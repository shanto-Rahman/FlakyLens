@Test public void assertIsExisted(){
assertTrue(zkRegCenter.isExisted("/test"));//RW
assertTrue(zkRegCenter.isExisted("/test/deep/nested"));//RW
assertFalse(zkRegCenter.isExisted("/notExisted"));//RW
}