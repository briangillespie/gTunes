package com.gtunes

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Song)
class SongSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test minimum duration"() { 

    	mockForConstraintsTests Song

    	def song = new Song(title: 'Lemonade', artist: 'Gucci Mane', duration: 0)

    	expect: !song.validate()
    	expect: 'min' == song.errors['duration']
    }
}
