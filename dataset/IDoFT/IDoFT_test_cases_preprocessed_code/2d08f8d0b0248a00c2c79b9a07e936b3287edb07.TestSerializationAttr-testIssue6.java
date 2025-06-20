public void testIssue6() throws IOException {
assertEquals("<Jurisdiction name=\"Foo\" value=\"13\"/>",_xmlMapper.writeValueAsString(new Jurisdiction()));
}