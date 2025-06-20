@Test public void testIsAssignableTo(){
Assert.assertTrue(alphaImpl.isAssignableTo(Alpha.class));//RW
Assert.assertTrue(abstractAlpha.isAssignableTo(Alpha.class));//RW
Assert.assertFalse(abstractAlpha.isAssignableTo(AlphaImpl.class));//RW
Assert.assertTrue(bravo.isAssignableTo(InnerInterface.class));//RW
Assert.assertTrue(bravo.isAssignableTo(AbstractAlpha.class));//RW
Assert.assertFalse(bravo.isAssignableTo(InnerClasses.class));//RW
}