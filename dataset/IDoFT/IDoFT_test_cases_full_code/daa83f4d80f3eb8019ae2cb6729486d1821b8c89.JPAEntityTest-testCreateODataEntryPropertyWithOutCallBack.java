@Test public void testCreateODataEntryPropertyWithOutCallBack(){
  try {
    EdmEntitySet edmEntitySet=EdmMockUtilV2.mockEdmEntitySet(JPATypeMock.ENTITY_NAME,false);
    EdmEntityType edmEntityType=edmEntitySet.getEntityType();
    jpaEntity=new JPAEntity(edmEntityType,edmEntitySet,mockODataJPAContextWithoutCallBack());
    jpaEntity.create(ODataEntryMockUtil.mockODataEntryProperties(JPATypeMock.ENTITY_NAME));
  }
 catch (  ODataJPARuntimeException e) {
    assertEquals(ODataJPARuntimeException.ERROR_JPA_BLOB_NULL.getKey(),e.getMessageReference().getKey());
    return;
  }
catch (  EdmException e) {
    fail(ODataJPATestConstants.EXCEPTION_MSG_PART_1 + e.getMessage() + ODataJPATestConstants.EXCEPTION_MSG_PART_2);
  }
catch (  ODataException e) {
    fail(ODataJPATestConstants.EXCEPTION_MSG_PART_1 + e.getMessage() + ODataJPATestConstants.EXCEPTION_MSG_PART_2);
  }
  fail(ODataJPATestConstants.EXCEPTION_EXPECTED);
}
