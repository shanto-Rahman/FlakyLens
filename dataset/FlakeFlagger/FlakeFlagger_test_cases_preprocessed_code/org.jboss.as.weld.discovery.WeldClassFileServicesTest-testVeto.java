@Test public void testVeto() throws IOException {
Assert.assertTrue(alpha.isVetoed());//RW
Assert.assertFalse(abstractAlpha.isVetoed());//RW
Assert.assertFalse(alphaImpl.isVetoed());//RW
Assert.assertTrue(bravo.isVetoed());//RW
}