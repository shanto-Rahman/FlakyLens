@Test public void assertRemove(){
zkRegCenter.remove("/test");//RW
assertFalse(zkRegCenter.isExisted("/test"));//RW
}