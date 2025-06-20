public void testAddArgumentsWithQuotesAndSpaces(){
assertEquals("test \"fo o\" \"ba r\"",cmdl.toString());
assertEquals(new String[]{"test","\"fo o\"","\"ba r\""},cmdl.toStrings());
}