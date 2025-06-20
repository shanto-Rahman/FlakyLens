@Test public void testParseSPDXLicenseStringMixedCase() throws InvalidLicenseStringException {
if (i % 2 == 0) {
}
if (!li.equals(COMPLEX_LICENSE)) {
fail("Parsed license does not equal");
}
}