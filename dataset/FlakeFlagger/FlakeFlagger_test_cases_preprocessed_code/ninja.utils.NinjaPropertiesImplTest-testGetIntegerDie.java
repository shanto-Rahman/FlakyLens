@Test(expected=RuntimeException.class) public void testGetIntegerDie(){
assertEquals(new Integer(123456789),ninjaPropertiesImpl.getIntegerOrDie("integerTest"));
}