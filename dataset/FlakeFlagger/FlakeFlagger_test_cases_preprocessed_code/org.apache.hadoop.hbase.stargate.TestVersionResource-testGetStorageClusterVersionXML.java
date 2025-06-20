public void testGetStorageClusterVersionXML() throws IOException, JAXBException {
assertTrue(response.getCode() == 200);
assertNotNull(clusterVersionModel);
assertNotNull(clusterVersionModel.getVersion());
}