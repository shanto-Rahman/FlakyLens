@Test public void matchAllTest(){
  CronPattern pattern;
  pattern=new CronPattern("* * * * *");
  Assert.assertTrue(pattern.match(DateUtil.current(false),true));
  Assert.assertTrue(pattern.match(DateUtil.current(false),false));
}
