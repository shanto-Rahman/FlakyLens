@Test public void testBindingConfigPathPatterns(){
assertFalse(binder.getBindingResult().hasErrors());
assertEquals(2,props.getConfigPathPatterns().length);
Assert.assertArrayEquals(new String[]{"pattern1","pattern2"},props.getConfigPathPatterns());
}