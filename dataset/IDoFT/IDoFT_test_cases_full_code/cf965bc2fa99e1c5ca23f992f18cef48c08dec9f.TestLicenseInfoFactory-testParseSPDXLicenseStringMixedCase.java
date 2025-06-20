@Test public void testParseSPDXLicenseStringMixedCase() throws InvalidLicenseStringException {
  String parseString=COMPLEX_LICENSE.toString();
  StringBuilder mixedCase=new StringBuilder();
  for (int i=0; i < parseString.length(); i++) {
    if (i % 2 == 0) {
      mixedCase.append(parseString.substring(i,i + 1).toUpperCase());
    }
 else {
      mixedCase.append(parseString.substring(i,i + 1).toLowerCase());
    }
  }
  AnyLicenseInfo li=LicenseInfoFactory.parseSPDXLicenseString(mixedCase.toString());
  if (!li.equals(COMPLEX_LICENSE)) {
    fail("Parsed license does not equal");
  }
}
