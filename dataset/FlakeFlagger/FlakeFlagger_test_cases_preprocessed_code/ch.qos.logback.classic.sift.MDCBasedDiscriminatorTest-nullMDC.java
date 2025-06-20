@Test public void nullMDC(){
assertEquals(new HashMap(),event.getMDCPropertyMap());
assertEquals(DEFAULT_VAL,discriminatorValue);//RW
}