@Test public void useNonExistenceOfSystemPropertyToDefineAContextProperty() throws JoranException {
assertNull(System.getProperty(sysKey));
assertNull(context.getProperty(dynaKey));
assertNotNull(context.getProperty(dynaKey));
}