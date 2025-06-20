@Test public void testBeanAnnotations(){
bean.setCustom_field("custom_field");//IT
bean.setDefault_field(null);//IT
bean.setNot_a_field("not_a_field");//IT
assertEquals(expected,mmcif);
}