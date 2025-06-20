@Test public void testMinimizeAttributePresence(){
assertEquals(false,resourceList.get(0).isMinimize());
assertEquals(true,resourceList.get(1).isMinimize());
assertEquals(true,resourceList.get(2).isMinimize());
}