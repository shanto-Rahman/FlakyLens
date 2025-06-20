@Test public void testSchemaToAttribute() throws Exception {
  final TestRunner testRunner=TestRunners.newTestRunner(new AttributesToCSV());
  testRunner.setProperty(AttributesToCSV.DESTINATION,OUTPUT_NEW_ATTRIBUTE);
  testRunner.setProperty(AttributesToCSV.INCLUDE_CORE_ATTRIBUTES,"false");
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
  testRunner.getFlowFilesForRelationship(AttributesToCSV.REL_SUCCESS).get(0).assertAttributeExists("CSVData");
  testRunner.getFlowFilesForRelationship(AttributesToCSV.REL_SUCCESS).get(0).assertAttributeExists("CSVSchema");
  testRunner.assertTransferCount(AttributesToCSV.REL_SUCCESS,1);
  testRunner.assertTransferCount(AttributesToCSV.REL_FAILURE,0);
  testRunner.getFlowFilesForRelationship(AttributesToCSV.REL_SUCCESS).get(0).assertAttributeEquals("CSVData","Malibu Beach,\"California, US\"");
  testRunner.getFlowFilesForRelationship(AttributesToCSV.REL_SUCCESS).get(0).assertAttributeEquals("CSVSchema","beach-name,beach-location");
}
