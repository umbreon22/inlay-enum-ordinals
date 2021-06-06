package com.github.umbreon22.inlayenumordinals.services

import com.github.umbreon22.inlayenumordinals.MyBundle
import com.intellij.openapi.project.Project

class MyProjectService(project: Project) {

    init {
        println(MyBundle.message("projectService", project.name))
    }
}
