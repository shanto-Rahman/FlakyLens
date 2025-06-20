public void testAddArgumentWithSpace(){
assertEquals("test foo \"ba r\"",cmdl.toString());
assertEquals(new String[]{"test","foo","\"ba r\""},cmdl.toStrings());
}