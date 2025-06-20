/** 
 * Tests the positioning, size, name and value of a form control appearing after an overflow page.
 */
@Test public void testFormControlAfterOverflowPage() throws IOException {
assertEquals(0,doc.getPage(0).getAnnotations().size());
assertEquals(0,doc.getPage(1).getAnnotations().size());
assertEquals(1,doc.getPage(2).getAnnotations().size());
assertThat(doc.getPage(2).getAnnotations().get(0),instanceOf(PDAnnotationWidget.class));
assertThat(widget.getRectangle(),rectEquals(new PDRectangle(13f,13f,60f,30f),100));
assertEquals(1,form.getFields().size());
assertThat(form.getFields().get(0),instanceOf(PDTextField.class));
assertEquals("text-input",field.getFullyQualifiedName());
assertEquals("Hello World!",field.getValue());
}