@Test public void testAppendProperties1() throws Exception {
TestCase.assertEquals(1,config.getI());//IT
TestCase.assertEquals('c',config.getC());//IT
TestCase.assertEquals((byte)0x02,config.getB());//IT
TestCase.assertEquals(3d,config.getD());//IT
TestCase.assertEquals(4f,config.getF());//IT
TestCase.assertEquals(5L,config.getL());//IT
TestCase.assertEquals(6,config.getS());//IT
TestCase.assertEquals("dubbo",config.getStr());//IT
TestCase.assertTrue(config.isBool());//IT
}