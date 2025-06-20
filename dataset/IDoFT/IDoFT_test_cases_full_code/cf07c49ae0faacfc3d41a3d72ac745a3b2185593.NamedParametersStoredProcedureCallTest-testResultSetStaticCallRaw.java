@Test public void testResultSetStaticCallRaw() throws Exception {
  inTransaction(entityManager -> {
    StoredProcedureQuery storedProcedureQuery=entityManager.createNamedStoredProcedureQuery("returnNamedParametersRaw");
    storedProcedureQuery.setParameter(RESULT_SET_PROC_ID_PARAM,2);
    storedProcedureQuery.setParameter(RESULT_SET_PROC_TITLE_PARAM,"title'2");
    List<?> listResult=storedProcedureQuery.getResultList();
    assertThat(listResult).hasSize(2);
    assertThat(((Number)listResult.get(0)).intValue()).isEqualTo(2);
    assertThat(listResult.get(1)).isEqualTo("title'2");
  }
);
}
