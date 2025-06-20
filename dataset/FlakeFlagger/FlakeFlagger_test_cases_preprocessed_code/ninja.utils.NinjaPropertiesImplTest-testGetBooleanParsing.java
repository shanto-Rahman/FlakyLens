@Test public void testGetBooleanParsing(){
assertEquals(true,ninjaPropertiesImpl.getBoolean("booleanTestTrue"));
assertEquals(false,ninjaPropertiesImpl.getBoolean("booleanTestFalse"));
assertEquals(null,ninjaPropertiesImpl.getBoolean("booleanNotValid"));
}