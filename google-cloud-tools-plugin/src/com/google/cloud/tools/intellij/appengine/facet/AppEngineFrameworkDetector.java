/*
 * Copyright 2000-2016 JetBrains s.r.o.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.tools.intellij.appengine.facet;

import com.google.cloud.tools.intellij.appengine.util.AppEngineUtilLegacy;

import com.intellij.facet.FacetType;
import com.intellij.framework.FrameworkType;
import com.intellij.framework.detection.FacetBasedFrameworkDetector;
import com.intellij.framework.detection.FileContentPattern;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.openapi.fileTypes.StdFileTypes;
import com.intellij.patterns.ElementPattern;
import com.intellij.util.indexing.FileContent;

import org.jetbrains.annotations.NotNull;

/**
 * @author nik
 */
public class AppEngineFrameworkDetector extends
    FacetBasedFrameworkDetector<AppEngineFacet, AppEngineFacetConfiguration> {

  public AppEngineFrameworkDetector() {
    super("appengine-java");
  }

  @Override
  public FacetType<AppEngineFacet, AppEngineFacetConfiguration> getFacetType() {
    return FacetType.findInstance(AppEngineFacetType.class);
  }

  @Override
  public FrameworkType getFrameworkType() {
    return AppEngineFrameworkType.getFrameworkType();
  }

  @NotNull
  @Override
  public FileType getFileType() {
    return StdFileTypes.XML;
  }

  @NotNull
  @Override
  public ElementPattern<FileContent> createSuitableFilePattern() {
    return FileContentPattern.fileContent().withName(AppEngineUtilLegacy.APP_ENGINE_WEB_XML_NAME)
        .xmlWithRootTag("appengine-web-app");
  }
}
