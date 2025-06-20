@Test public void tesConcludedLicensetCol() throws Exception {
  AnyLicenseInfo diffLicense=new SpdxNoAssertionLicense();
  String different=diffLicense.toString();
  getDescribedPackage(doc3).setLicenseConcluded(diffLicense);
  comparer.compare(new SpdxDocument[]{doc1,doc2,doc3});
  pkgSheet.importCompareResults(comparer,docNames);
  Row row=findRow(PackageSheet.CONCLUDED_LICENSE_FIELD_TEXT);
  assertEquals(PackageSheet.DIFFERENT_STRING,getEqualCellValue(row));
  assertEquals(getDescribedPackage(doc1).getLicenseConcluded().toString(),getDocCellValue(0,row));
  assertEquals(getDescribedPackage(doc2).getLicenseConcluded().toString(),getDocCellValue(1,row));
  assertEquals(different,getDocCellValue(2,row));
  comparer.compare(new SpdxDocument[]{doc1,doc2});
  pkgSheet.importCompareResults(comparer,new String[]{docNames[0],docNames[1]});
  row=findRow(PackageSheet.CONCLUDED_LICENSE_FIELD_TEXT);
  assertEquals(PackageSheet.EQUAL_STRING,getEqualCellValue(row));
}
