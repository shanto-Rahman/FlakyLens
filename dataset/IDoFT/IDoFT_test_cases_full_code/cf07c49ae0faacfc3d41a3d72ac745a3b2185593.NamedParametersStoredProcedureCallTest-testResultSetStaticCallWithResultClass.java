@Test public void testResultSetStaticCallWithResultClass() throws Exception {
  inTransaction(entityManager -> {
    StoredProcedureQuery storedProcedureQuery=entityManager.createNamedStoredProcedureQuery("returnNamedParametersWithEntity");
    storedProcedureQuery.setParameter(RESULT_SET_PROC_ID_PARAM,1);
    storedProcedureQuery.setParameter(RESULT_SET_PROC_TITLE_PARAM,"title");
    @SuppressWarnings("unchecked") List<Car> listResult=storedProcedureQuery.getResultList();
    assertThat(listResult).containsExactly(new Car(1,"title"));
  }
);
}
