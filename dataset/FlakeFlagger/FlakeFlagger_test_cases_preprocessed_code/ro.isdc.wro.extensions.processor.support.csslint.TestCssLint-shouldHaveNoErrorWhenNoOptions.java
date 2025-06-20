@Test public void shouldHaveNoErrorWhenNoOptions() throws Exception {
cssLint.validate(IOUtils.toString(new FileInputStream(url.getFile())));
}