@Test public void matchAllTest(){
Assert.assertTrue(pattern.match(DateUtil.current(false),true));
Assert.assertTrue(pattern.match(DateUtil.current(false),false));
}