@Test public void testTopLevelClass(){
Assert.assertTrue(alpha.isTopLevelClass());//RW
Assert.assertTrue(alpha.isTopLevelClass());//RW
Assert.assertTrue(alpha.isTopLevelClass());//RW
Assert.assertFalse(innerInterface.isTopLevelClass());//RW
}