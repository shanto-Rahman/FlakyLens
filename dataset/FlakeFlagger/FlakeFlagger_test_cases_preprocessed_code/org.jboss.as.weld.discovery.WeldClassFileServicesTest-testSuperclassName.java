@Test public void testSuperclassName(){
Assert.assertEquals(Object.class.getName(),alpha.getSuperclassName());//RW
Assert.assertEquals(Object.class.getName(),abstractAlpha.getSuperclassName());//RW
Assert.assertEquals(AbstractAlpha.class.getName(),alphaImpl.getSuperclassName());//RW
}