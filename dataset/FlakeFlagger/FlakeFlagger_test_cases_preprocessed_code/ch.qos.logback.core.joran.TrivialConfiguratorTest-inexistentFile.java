@Test public void inexistentFile(){
assertTrue(e.getMessage().startsWith("Could not open ["));
assertTrue(tsl.list.size() + " should be greater than or equal to 1",tsl.list.size() >= 1);
assertTrue(s0.getMessage().startsWith("Could not open ["));
}