package com.gtunes

class AlbumController {

    static scaffold = Album

    def show(){
    	[album: Album.get(params.id)]
    }

    def save(){
    	def album = Album.get(params.id)
    	album.properties = params
    	if(album.save()){ 
    		// Show this album
    		redirect action: "show", id: album.id
    	} else {
    		// Send user back to edit page if they entered bad data
    		album.errors.allErrors.each { println it.code }
    		render view: "edit", model [album: Album]
    	}
    }

    def update(){
    	def album = Album.get(params.id)
    	album.properties = params
    	album.save()
    }
}