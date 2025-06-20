@Test public void testExclusive(){
assertFalse(isValid(validator,new ModelNode(0)));
assertTrue(isValid(validator,new ModelNode(0.1)));
assertTrue(isValid(validator,new ModelNode(Double.MAX_VALUE)));
assertTrue(isValid(validator,new ModelNode(Double.MIN_VALUE)));
assertTrue(isValid(validator,new ModelNode(0.99)));
assertFalse(isValid(validator,new ModelNode(1)));
}