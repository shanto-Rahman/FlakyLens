@Test public void testBindingDisabledPlugins(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals(2,props.getDisabledPlugins().length);
assertArrayEquals(new String[]{"pattern1","pattern2"},props.getDisabledPlugins());
}