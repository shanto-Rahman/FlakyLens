/** 
 * Tests the positioning, size, name and value of a form control on an overflow page.
 */
@Test public void testFormControlOverflowPage() throws IOException {
  PDDocument doc=run("form-control-overflow-page");
  assertEquals(0,doc.getPage(0).getAnnotations().size());
  assertEquals(1,doc.getPage(1).getAnnotations().size());
  assertThat(doc.getPage(1).getAnnotations().get(0),instanceOf(PDAnnotationWidget.class));
  PDAnnotationWidget widget=(PDAnnotationWidget)doc.getPage(1).getAnnotations().get(0);
  assertThat(widget.getRectangle(),rectEquals(new PDRectangle(33f,14f,40f,20f),100));
  PDAcroForm form=doc.getDocumentCatalog().getAcroForm();
  assertEquals(1,form.getFields().size());
  assertThat(form.getFields().get(0),instanceOf(PDTextField.class));
  PDTextField field=(PDTextField)form.getFields().get(0);
  assertEquals("text-input",field.getFullyQualifiedName());
  assertEquals("Hello World!",field.getValue());
  remove("form-control-overflow-page",doc);
}
