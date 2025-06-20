@Test public void testFileParse(){
  String file="mapping/config.xml";
  BeanMappingConfigHelper.getInstance().registerConfig(file);
  BeanMappingObject object=BeanMappingConfigHelper.getInstance().getBeanMappingObject(HashMap.class,HashMap.class);
  assertNull(object);
  object=BeanMappingConfigHelper.getInstance().getBeanMappingObject("testConfig");
  printObject(object);
  assertNotNull(object);
  BeanMappingBehavior globalBehavior=BeanMappingConfigHelper.getInstance().getGlobalBehavior();
  Assert.assertEquals(globalBehavior.isMappingNullValue(),true);
  Assert.assertEquals(globalBehavior.isMappingEmptyStrings(),true);
  Assert.assertEquals(globalBehavior.isDebug(),false);
  Assert.assertEquals(globalBehavior.isTrimStrings(),true);
  BeanMappingBehavior beanBehavior=object.getBehavior();
  Assert.assertEquals(beanBehavior.isMappingNullValue(),false);
  Assert.assertEquals(beanBehavior.isDebug(),true);
  Assert.assertEquals(beanBehavior.isMappingEmptyStrings(),true);
  Assert.assertEquals(beanBehavior.isTrimStrings(),true);
  BeanMappingField field=object.getBeanFields().get(0);
  BeanMappingBehavior fieldBehavior=field.getBehavior();
  Assert.assertEquals(fieldBehavior.isMappingNullValue(),true);
  Assert.assertEquals(fieldBehavior.isDebug(),true);
  Assert.assertEquals(fieldBehavior.isMappingEmptyStrings(),true);
  Assert.assertEquals(fieldBehavior.isTrimStrings(),true);
}
