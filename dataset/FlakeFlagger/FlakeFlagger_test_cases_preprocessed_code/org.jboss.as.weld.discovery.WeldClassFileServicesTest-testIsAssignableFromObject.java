@Test public void testIsAssignableFromObject(){
Assert.assertFalse(alpha.isAssignableFrom(Object.class));//RW
Assert.assertFalse(abstractAlpha.isAssignableFrom(Object.class));//RW
Assert.assertFalse(alphaImpl.isAssignableFrom(Object.class));//RW
Assert.assertFalse(bravo.isAssignableFrom(Object.class));//RW
}