@Test public void testIsAssignableToObject(){
Assert.assertTrue(alpha.isAssignableTo(Object.class));//RW
Assert.assertTrue(abstractAlpha.isAssignableTo(Object.class));//RW
Assert.assertTrue(alphaImpl.isAssignableTo(Object.class));//RW
Assert.assertTrue(bravo.isAssignableTo(Object.class));//RW
}