/** 
 * Tests the positioning, size, name and value of a text type form control.
 */
@Test public void testFormControlText() throws IOException {
assertEquals(1,doc.getPage(0).getAnnotations().size());
assertThat(doc.getPage(0).getAnnotations().get(0),instanceOf(PDAnnotationWidget.class));
assertThat(widget.getRectangle(),rectEquals(new PDRectangle(23f,23f,100f,20f),200));
assertEquals(1,form.getFields().size());
assertThat(form.getFields().get(0),instanceOf(PDTextField.class));
assertEquals("text-input",field.getFullyQualifiedName());
assertEquals("Hello World!",field.getValue());
}