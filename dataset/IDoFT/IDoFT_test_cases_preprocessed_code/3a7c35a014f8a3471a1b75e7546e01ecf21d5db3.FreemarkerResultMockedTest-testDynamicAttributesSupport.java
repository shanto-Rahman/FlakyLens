public void testDynamicAttributesSupport() throws Exception {
File file=new File(FreeMarkerResultTest.class.getResource("dynaAttributes.ftl").toURI());//RO
file=new File(ClassLoaderUtil.getResource("template/simple/text.ftl",getClass()).toURI());//RO
file=new File(ClassLoaderUtil.getResource("template/simple/css.ftl",getClass()).toURI());//RO
file=new File(ClassLoaderUtil.getResource("template/simple/scripting-events.ftl",getClass()).toURI());//RO
file=new File(ClassLoaderUtil.getResource("template/simple/common-attributes.ftl",getClass()).toURI());//RO
file=new File(ClassLoaderUtil.getResource("template/simple/dynamic-attributes.ftl",getClass()).toURI());//RO
if (result.contains("id=\"test\" foo=\"bar\"")) {
assertEquals(expectedJDK18,result);
assertEquals(expectedJDK17,result);
}
}