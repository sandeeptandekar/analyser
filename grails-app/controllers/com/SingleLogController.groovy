package com



import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class SingleLogController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond SingleLog.list(params), model:[singleLogInstanceCount: SingleLog.count()]
    }

    def show(SingleLog singleLogInstance) {
        respond singleLogInstance
    }

    def create() {
        respond new SingleLog(params)
    }

    @Transactional
    def save(SingleLog singleLogInstance) {
        if (singleLogInstance == null) {
            notFound()
            return
        }

        if (singleLogInstance.hasErrors()) {
            respond singleLogInstance.errors, view:'create'
            return
        }

        singleLogInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'singleLog.label', default: 'SingleLog'), singleLogInstance.id])
                redirect singleLogInstance
            }
            '*' { respond singleLogInstance, [status: CREATED] }
        }
    }

    def edit(SingleLog singleLogInstance) {
        respond singleLogInstance
    }

    @Transactional
    def update(SingleLog singleLogInstance) {
        if (singleLogInstance == null) {
            notFound()
            return
        }

        if (singleLogInstance.hasErrors()) {
            respond singleLogInstance.errors, view:'edit'
            return
        }

        singleLogInstance.save flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'SingleLog.label', default: 'SingleLog'), singleLogInstance.id])
                redirect singleLogInstance
            }
            '*'{ respond singleLogInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(SingleLog singleLogInstance) {

        if (singleLogInstance == null) {
            notFound()
            return
        }

        singleLogInstance.delete flush:true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'SingleLog.label', default: 'SingleLog'), singleLogInstance.id])
                redirect action:"index", method:"GET"
            }
            '*'{ render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'singleLog.label', default: 'SingleLog'), params.id])
                redirect action: "index", method: "GET"
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
