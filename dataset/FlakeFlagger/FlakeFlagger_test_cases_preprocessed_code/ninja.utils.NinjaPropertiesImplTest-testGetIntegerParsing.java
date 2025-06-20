@Test public void testGetIntegerParsing(){
assertEquals(new Integer(123456789),ninjaPropertiesImpl.getInteger("integerTest"));
assertEquals(null,ninjaPropertiesImpl.getInteger("integerNotValid"));
}