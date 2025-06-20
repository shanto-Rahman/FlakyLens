@Test public void testModifiers() throws IOException {
Assert.assertTrue(Modifier.isAbstract(alpha.getModifiers()));//RW
Assert.assertTrue(Modifier.isAbstract(abstractAlpha.getModifiers()));//RW
Assert.assertFalse(Modifier.isAbstract(alphaImpl.getModifiers()));//RW
Assert.assertFalse(Modifier.isStatic(alpha.getModifiers()));//RW
Assert.assertFalse(Modifier.isStatic(abstractAlpha.getModifiers()));//RW
Assert.assertFalse(Modifier.isStatic(alphaImpl.getModifiers()));//RW
}