@Test public void testScanForAnnotation(){
assertTrue(classSet.contains(MyTestBean.class));
assertTrue(classSet.contains(MyBlueTestBean.class));
assertTrue(classSet.contains(MyRedTestBean.class));
assertTrue(classSet.contains(MyPurpleTestBean.class));
assertTrue(classSet.contains(MyCustomIdBean.class));
assertEquals(count,classSet.size());
}