@Test public void testResultSetStaticCallRaw() throws Exception {
  inTransaction(entityManager -> {
    StoredProcedureQuery storedProcedureQuery=entityManager.createNamedStoredProcedureQuery("returnPositionalParametersRaw");
    storedProcedureQuery.setParameter(2,2);
    storedProcedureQuery.setParameter(3,"title'2");
    List<?> listResult=storedProcedureQuery.getResultList();
    assertThat(listResult).hasSize(2);
    assertThat(((Number)listResult.get(0)).intValue()).isEqualTo(2);
    assertThat(listResult.get(1)).isEqualTo("title'2");
  }
);
}
