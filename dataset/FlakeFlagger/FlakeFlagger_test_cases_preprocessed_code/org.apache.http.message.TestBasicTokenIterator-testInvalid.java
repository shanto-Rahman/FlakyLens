@Test public void testInvalid(){
Assert.assertTrue(ti.hasNext());
Assert.fail("invalid infix character not detected");
Assert.assertTrue(ti.hasNext());
Assert.fail("missing token separator not detected");
Assert.fail("invalid prefix character not detected");
Assert.assertTrue(ti.hasNext());
Assert.assertEquals("token0","token0",ti.nextToken());
Assert.assertTrue(ti.hasNext());
Assert.fail("invalid postfix character not detected");
}