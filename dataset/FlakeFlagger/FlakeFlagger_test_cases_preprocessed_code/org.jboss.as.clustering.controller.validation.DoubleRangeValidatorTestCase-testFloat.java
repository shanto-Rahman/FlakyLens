@Test public void testFloat(){
assertFalse(isValid(validator,new ModelNode(Double.MAX_VALUE)));
assertFalse(isValid(validator,new ModelNode(Double.MIN_VALUE)));
assertTrue(isValid(validator,new ModelNode(Float.MAX_VALUE)));
assertTrue(isValid(validator,new ModelNode(Float.MIN_VALUE)));
}