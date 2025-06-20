@Test(expected=RuntimeException.class) public void testGetOrDie(){
assertEquals("dev_testproperty",ninjaPropertiesImpl.getOrDie("testproperty"));
}