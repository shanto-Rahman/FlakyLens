@Test public void testDeclaredLicenseCol() throws Exception {
  AnyLicenseInfo diffLicense=new SpdxNoAssertionLicense();
  String different=diffLicense.toString();
  getDescribedPackage(doc3).setLicenseDeclared(diffLicense);
  comparer.compare(new SpdxDocument[]{doc1,doc2,doc3});
  pkgSheet.importCompareResults(comparer,docNames);
  Row row=findRow(PackageSheet.DECLARED_LICENSE_FIELD_TEXT);
  assertEquals(PackageSheet.DIFFERENT_STRING,getEqualCellValue(row));
  assertEquals(getDescribedPackage(doc1).getLicenseDeclared().toString(),getDocCellValue(0,row));
  assertEquals(getDescribedPackage(doc2).getLicenseDeclared().toString(),getDocCellValue(1,row));
  assertEquals(different,getDocCellValue(2,row));
  comparer.compare(new SpdxDocument[]{doc1,doc2});
  pkgSheet.importCompareResults(comparer,new String[]{docNames[0],docNames[1]});
  row=findRow(PackageSheet.DECLARED_LICENSE_FIELD_TEXT);
  assertEquals(PackageSheet.EQUAL_STRING,getEqualCellValue(row));
}
