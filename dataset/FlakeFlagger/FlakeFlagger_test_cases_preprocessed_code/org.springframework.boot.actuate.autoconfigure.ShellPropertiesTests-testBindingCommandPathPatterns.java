@Test public void testBindingCommandPathPatterns(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals(2,props.getCommandPathPatterns().length);
Assert.assertArrayEquals(new String[]{"pattern1","pattern2"},props.getCommandPathPatterns());
}