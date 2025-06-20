@Test public void testCreateODataEntryPropertyWithOutCallBack(){
assertThat(e.getMessageReference().getKey(),either(is(ODataJPARuntimeException.ERROR_JPA_BLOB_NULL.getKey())).or(is(ODataJPARuntimeException.ERROR_JPA_CLOB_NULL.getKey())));
fail(ODataJPATestConstants.EXCEPTION_MSG_PART_1 + e.getMessage() + ODataJPATestConstants.EXCEPTION_MSG_PART_2);
fail(ODataJPATestConstants.EXCEPTION_MSG_PART_1 + e.getMessage() + ODataJPATestConstants.EXCEPTION_MSG_PART_2);
fail(ODataJPATestConstants.EXCEPTION_EXPECTED);
}