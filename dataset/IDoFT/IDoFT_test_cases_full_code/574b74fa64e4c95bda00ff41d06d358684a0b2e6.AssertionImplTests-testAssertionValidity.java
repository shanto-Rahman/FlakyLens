public void testAssertionValidity() throws Exception {
  final Assertion assertion=new AssertionImpl(CONST_PRINCIPAL,new Date(),new Date(),new Date(),CONST_ATTRIBUTES);
  assertTrue(assertion.isValid());
}
