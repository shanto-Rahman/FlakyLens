public void testAddArgumentWithSingleQuote(){
assertEquals("test foo \"ba'r\"",cmdl.toString());
assertEquals(new String[]{"test","foo","\"ba\'r\""},cmdl.toStrings());
}