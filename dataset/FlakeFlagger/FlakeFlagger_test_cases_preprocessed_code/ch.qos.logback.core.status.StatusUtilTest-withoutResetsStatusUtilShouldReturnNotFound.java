@Test public void withoutResetsStatusUtilShouldReturnNotFound(){
assertEquals(-1,statusUtil.timeOfLastReset());
}