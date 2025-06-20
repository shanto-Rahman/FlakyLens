@Test public void testBeanAnnotations(){
  DemoBean bean=new DemoBean();
  bean.setCustom_field("custom_field");
  bean.setDefault_field(null);
  bean.setNot_a_field("not_a_field");
  String newline=System.getProperty("line.separator");
  String mmcif=MMCIFFileTools.toMMCIF("_demo",bean);
  String expected="_demo.default_field   ?" + newline + "_demo.custom_label    custom_field"+ newline+ "#"+ newline;
  assertEquals(expected,mmcif);
}
