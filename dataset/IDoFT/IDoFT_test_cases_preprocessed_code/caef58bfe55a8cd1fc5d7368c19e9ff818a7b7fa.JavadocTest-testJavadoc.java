@Test public void testJavadoc(){
settings.javadocXmlFiles=Arrays.asList(new File("src/test/javadoc/test-javadoc.xml"));//RO
Assert.assertEquals("Documentation for ClassWithJavadoc. First line.",bean.getComments().get(0));
Assert.assertEquals("Second line.",bean.getComments().get(1));
Assert.assertEquals("Documentation for documentedField.",property1.getComments().get(0));
Assert.assertEquals("Documentation for documentedEnumField.",property2.getComments().get(0));
Assert.assertEquals("Documentation for DummyEnum.",enumModel.getComments().get(0));
Assert.assertNull(bean.getComments());
Assert.assertNull(property.getComments());
Assert.assertTrue(generated.contains("Documentation for ClassWithJavadoc. First line."));
Assert.assertTrue(generated.contains("Second line."));
Assert.assertTrue(generated.contains("Documentation for documentedField."));
Assert.assertTrue(generated.contains("Documentation for documentedEnumField."));
Assert.assertTrue(generated.contains("Documentation for DummyEnum."));
Assert.assertTrue(generated.contains("Documentation for getter property."));
Assert.assertTrue(generated.contains("Documentation for renamed field."));
Assert.assertTrue(generated.contains("Documentation for InterfaceWithJavadoc."));
Assert.assertTrue(generated.contains("Documentation for interface getter property."));
Assert.assertTrue(generated.contains("@return value of getterPropery"));
Assert.assertTrue(generated.contains("@deprecated replaced by something else"));
Assert.assertTrue(generated.contains(" *     // indentation and line breaks are kept\n * \n *     {@literal @}"));
Assert.assertTrue(generated.contains(" *     public List<String> generics() {\n"));
Assert.assertTrue(generated.contains("ff0000"));
Assert.assertTrue(generated.contains("00ff00"));
Assert.assertTrue(generated.contains("0000ff"));
Assert.assertTrue(!generated.contains("<br>"));
Assert.assertTrue(!generated.contains("<br/>"));
Assert.assertTrue(!generated.contains("<br />"));
Assert.assertTrue(generated.contains("Class documentation\n * \n"));
Assert.assertTrue(generated.contains("Some documentation\n * \n * for this class."));
Assert.assertTrue(!generated.contains("<p>"));
Assert.assertTrue(!generated.contains("</p>"));
Assert.assertTrue(generated.contains("Long\n * paragraph\n * \n * Second\n * paragraph"));
}