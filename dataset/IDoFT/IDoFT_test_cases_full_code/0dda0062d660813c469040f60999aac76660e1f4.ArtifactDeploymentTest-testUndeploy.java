private void testUndeploy(final UndeployArtifactMojo mojo,final String classifier) throws Exception {
  if (!deploymentManager.hasDeployment(artifactName)) {
    deploymentManager.deploy(Deployment.of(Paths.get(BASE_CONFIG_DIR,artifactName)));
  }
  mojo.project.setDependencyArtifacts(Collections.singleton(createArtifact(classifier)));
  mojo.execute();
  assertFalse("Deployment " + artifactName + " was not undeployed",deploymentManager.hasDeployment(artifactName));
}
