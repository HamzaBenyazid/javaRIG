#!/usr/bin/env groovy

def prepareGradleCommand(tasks, props = [:]) {
    def options = props.collect { k, v ->
        def option = "-D${k}"
        if (v != null && !v.toString().isEmpty()) {
            option += "='${v}'"
        }
        return option
    }.join(' ')
    return "mvn ${tasks} ${options}"
}

def execute(tasks, props = [:]) {
    sh prepareGradleCommand(tasks, props)
}

def executeWithDebug(tasks, props = [:]) {
    sh prepareGradleCommand(tasks, props) + "--debug"
}

def executeWithStackTrace(tasks, props = [:]) {
    sh prepareGradleCommand(tasks, props) + "--exception"
}

def executeWithDebugStacktrace(tasks, props = [:]) {
    sh prepareGradleCommand(tasks, props) + "--debug --exception"
}