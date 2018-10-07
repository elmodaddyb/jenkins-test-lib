package com.srcdevbin

import spock.lang.Specification

class SourceUtilsTest extends Specification {
	
	def subject
	
	def setup() {
		subject = new SourceUtils(this)
	}
	
	def 'SourceUtils calls checkout'() {
		when:
		subject.checkoutSource {
			url = 'https://github.com/elmodaddyb/cmake-gtest.git'
		}
		
		then:
		println 'hello'
	}
	
	def sh(command) {
		println command
	}
	
}