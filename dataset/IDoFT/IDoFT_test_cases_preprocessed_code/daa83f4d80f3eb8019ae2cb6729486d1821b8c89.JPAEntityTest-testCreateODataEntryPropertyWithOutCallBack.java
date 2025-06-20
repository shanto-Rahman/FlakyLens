@Test public void testCreateODataEntryPropertyWithOutCallBack(){
assertEquals(ODataJPARuntimeException.ERROR_JPA_BLOB_NULL.getKey(),e.getMessageReference().getKey());
fail(ODataJPATestConstants.EXCEPTION_MSG_PART_1 + e.getMessage() + ODataJPATestConstants.EXCEPTION_MSG_PART_2);
fail(ODataJPATestConstants.EXCEPTION_MSG_PART_1 + e.getMessage() + ODataJPATestConstants.EXCEPTION_MSG_PART_2);
fail(ODataJPATestConstants.EXCEPTION_EXPECTED);
}