/** 
 * Check that an input without name attribute does not launch a NPE. Will now log a warning message. See issue: https://github.com/danfickle/openhtmltopdf/issues/151 Additionally, check that a select element without options will not launch a NPE too.
 */
@Test public void testInputWithoutNameAttribute() throws IOException {
  PDDocument doc=run("input-without-name-attribute");
  PDAcroForm form=doc.getDocumentCatalog().getAcroForm();
  assertEquals(0,form.getFields().size());
  remove("input-without-name-attribute",doc);
}
