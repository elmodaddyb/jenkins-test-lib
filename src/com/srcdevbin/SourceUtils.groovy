package com.srcdevbin


class SourceUtils implements Serializable {
	
	def url
	def script
	
	SourceUtils(script) { 
		this.script = script 
	}
	
	def checkoutSource(Closure cl) {
		cl()
		script {
			script.sh "echo hello - ${url}"
		}
	}
	
//	def invokeClosure(cl) {
//		Closure clonedCl = cl.clone()
//		clonedCl.delegate = this
//		clonedCl.resolveStrategy = Closure.DELEGATE_FIRST
//		script.println clonedCl.delegate
//		clonedCl()
//		script.println "The URL - ${url}"
//	}
	
	def script(Closure cl) {
		Closure clonedCl = cl.clone()
		clonedCl.delegate = script
		clonedCl.resolveStrategy = Closure.OWNER_FIRST
		clonedCl()
	}
}
