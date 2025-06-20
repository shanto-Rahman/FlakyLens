@Test public void testSchemaWithCoreAttribuesToAttribute() throws Exception {
  final TestRunner testRunner=TestRunners.newTestRunner(new AttributesToCSV());
  testRunner.setProperty(AttributesToCSV.DESTINATION,OUTPUT_NEW_ATTRIBUTE);
  testRunner.setProperty(AttributesToCSV.INCLUDE_CORE_ATTRIBUTES,"true");
  testRunner.setProperty(AttributesToCSV.NULL_VALUE_FOR_EMPTY_STRING,"false");
  testRunner.setProperty(AttributesToCSV.INCLUDE_SCHEMA,"true");
  testRunner.setProperty(AttributesToCSV.ATTRIBUTES_REGEX,"beach-.*");
  Map<String,String> attrs=new HashMap<String,String>(){
{
      put("beach-name","Malibu Beach");
      put("beach-location","California, US");
      put("attribute-should-be-eliminated","This should not be in CSVData!");
    }
  }
;
  testRunner.enqueue(new byte[0],attrs);
  testRunner.run();
  testRunner.assertTransferCount(AttributesToCSV.REL_SUCCESS,1);
  testRunner.assertTransferCount(AttributesToCSV.REL_FAILURE,0);
  MockFlowFile flowFile=testRunner.getFlowFilesForRelationship(AttributesToCSV.REL_SUCCESS).get(0);
  flowFile.assertAttributeExists("CSVData");
  flowFile.assertAttributeExists("CSVSchema");
  final String path=flowFile.getAttribute("path");
  final String filename=flowFile.getAttribute("filename");
  final String uuid=flowFile.getAttribute("uuid");
  flowFile.assertAttributeEquals("CSVData","Malibu Beach,\"California, US\"," + path + ","+ filename+ ","+ uuid);
  flowFile.assertAttributeEquals("CSVSchema","beach-name,beach-location,path,filename,uuid");
}
