public void testAddArguments(){
assertEquals("test foo bar",cmdl.toString());
assertEquals(new String[]{"test","foo","bar"},cmdl.toStrings());
}