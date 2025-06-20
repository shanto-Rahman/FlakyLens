@Test public void testNoHeaders(){
Assert.assertTrue(context.isComplete());
Assert.assertEquals("/aa",result.getRelativePath());
}