@Test public void testCyclicReference(){
assertTrue("Cyclic reference should be encoded as $ref:str=" + str,str.indexOf("testBean:{\n      $ref:`../../`\n") > 0);
assertEquals(tb1.getBean2().testBean,tb1);
}