@Test public void testBigram(){
Assert.assertTrue("a probability measure should be between 0 and 1 [was " + probability + "]",probability >= 0 && probability <= 1);
Assert.assertNotNull(tokens);
Assert.assertArrayEquals(new String[]{"something"},tokens);
}