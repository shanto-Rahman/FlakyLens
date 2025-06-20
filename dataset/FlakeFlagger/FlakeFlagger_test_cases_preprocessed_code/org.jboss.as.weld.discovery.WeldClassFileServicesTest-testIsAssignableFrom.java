@Test public void testIsAssignableFrom(){
Assert.assertTrue(alpha.isAssignableFrom(AlphaImpl.class));//RW
Assert.assertTrue(abstractAlpha.isAssignableFrom(AlphaImpl.class));//RW
Assert.assertFalse(abstractAlpha.isAssignableFrom(Alpha.class));//RW
Assert.assertTrue(innerInterface.isAssignableFrom(Bravo.class));//RW
Assert.assertTrue(alphaImpl.isAssignableFrom(Bravo.class));//RW
}