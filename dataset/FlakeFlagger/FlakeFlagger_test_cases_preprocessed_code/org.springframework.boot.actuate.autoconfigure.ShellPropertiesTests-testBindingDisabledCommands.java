@Test public void testBindingDisabledCommands(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals(2,props.getDisabledCommands().length);
assertArrayEquals(new String[]{"pattern1","pattern2"},props.getDisabledCommands());
}