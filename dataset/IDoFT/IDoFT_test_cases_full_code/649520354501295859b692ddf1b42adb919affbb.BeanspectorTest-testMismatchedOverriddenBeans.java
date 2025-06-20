@Test(expected=IllegalArgumentException.class) public void testMismatchedOverriddenBeans() throws SearchParseException {
  new Beanspector<MismatchedOverriddenBean>(new MismatchedOverriddenBean());
}
