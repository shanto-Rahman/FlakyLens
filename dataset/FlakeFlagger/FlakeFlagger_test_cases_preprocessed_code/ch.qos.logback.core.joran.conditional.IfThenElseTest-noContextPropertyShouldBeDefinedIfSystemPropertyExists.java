@Test public void noContextPropertyShouldBeDefinedIfSystemPropertyExists() throws JoranException {
assertNull(context.getProperty(dynaKey));
assertNull(context.getProperty(dynaKey));
}