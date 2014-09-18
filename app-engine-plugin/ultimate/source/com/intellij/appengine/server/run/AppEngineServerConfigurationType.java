package com.intellij.appengine.server.run;

import com.intellij.appengine.server.instance.AppEngineServerModel;
import com.intellij.appengine.server.integration.AppEngineServerIntegration;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.javaee.appServerIntegrations.AppServerIntegration;
import com.intellij.javaee.run.configuration.J2EEConfigurationFactory;
import com.intellij.javaee.run.configuration.J2EEConfigurationType;
import com.intellij.openapi.project.Project;
import icons.GoogleAppEngineIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

/**
 * @author nik
 */
public class AppEngineServerConfigurationType extends J2EEConfigurationType {
  public static AppEngineServerConfigurationType getInstance() {
    return ConfigurationTypeUtil.findConfigurationType(AppEngineServerConfigurationType.class);
  }

  protected RunConfiguration createJ2EEConfigurationTemplate(ConfigurationFactory factory, Project project, boolean isLocal) {
    final AppEngineServerModel serverModel = new AppEngineServerModel();
    return J2EEConfigurationFactory.getInstance().createJ2EERunConfiguration(factory, project, serverModel,
                                                                             getIntegration(), isLocal, new AppEngineServerStartupPolicy());
  }

  public String getDisplayName() {
    return "Google AppEngine Dev Server";
  }

  public String getConfigurationTypeDescription() {
    return "Google AppEngine Dev Server run configuration";
  }

  @Nullable
  public Icon getIcon() {
    return GoogleAppEngineIcons.AppEngine;
  }

  @Override
  public ConfigurationFactory[] getConfigurationFactories() {
    return new ConfigurationFactory[] {super.getConfigurationFactories()[0]};
  }

  public AppServerIntegration getIntegration() {
    return AppEngineServerIntegration.getInstance();
  }

  @NotNull
  public String getId() {
    return "GoogleAppEngineDevServer";
  }
}