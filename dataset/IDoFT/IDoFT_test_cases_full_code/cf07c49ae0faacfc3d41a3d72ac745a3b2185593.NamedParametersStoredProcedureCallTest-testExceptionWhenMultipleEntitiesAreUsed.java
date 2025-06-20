@Test public void testExceptionWhenMultipleEntitiesAreUsed() throws Exception {
  inTransaction(entityManager -> {
    thrown.expect(PersistenceException.class);
    thrown.expectCause(isA(HibernateException.class));
    thrown.expectMessage("org.hibernate.HibernateException: OGM000090: Returning multiple entities is not supported. Procedure '" + RESULT_SET_PROC + "' expects results of type [Car, Motorbike]");
    StoredProcedureQuery storedProcedureQuery=entityManager.createStoredProcedureQuery(RESULT_SET_PROC,Car.class,Motorbike.class);
    storedProcedureQuery.registerStoredProcedureParameter(0,Void.class,ParameterMode.REF_CURSOR);
    storedProcedureQuery.registerStoredProcedureParameter(1,Integer.class,ParameterMode.IN);
    storedProcedureQuery.registerStoredProcedureParameter(2,String.class,ParameterMode.IN);
    storedProcedureQuery.setParameter(1,1);
    storedProcedureQuery.setParameter(2,"title");
    storedProcedureQuery.getResultList();
  }
);
}
