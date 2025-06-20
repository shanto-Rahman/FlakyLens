@Test public void testEmptyExpressionThrowsException() throws Exception {
Assert.assertEquals("Error evaluating parallel loop expression in step 'nodeName', error is: \n" + "expression is empty",exception.getMessage());
}