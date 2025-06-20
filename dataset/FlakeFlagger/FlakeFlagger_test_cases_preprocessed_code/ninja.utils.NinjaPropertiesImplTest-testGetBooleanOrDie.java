@Test(expected=RuntimeException.class) public void testGetBooleanOrDie(){
assertEquals(true,ninjaPropertiesImpl.getBooleanOrDie("booleanTestTrue"));
}