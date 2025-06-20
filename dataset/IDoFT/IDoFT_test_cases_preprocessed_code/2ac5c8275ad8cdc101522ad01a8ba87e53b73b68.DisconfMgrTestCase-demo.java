@Test public void demo(){
Assert.assertEquals(new Long(1000),confA.getVarA());
Assert.assertEquals(new Long(2000),confA.getVarA2());
Assert.assertEquals(new Integer(1000).intValue(),serviceA.getVarAA());
Assert.assertEquals(new Integer(50).intValue(),StaticConf.getStaticvar());
Assert.assertTrue(false);
}